package com.jayatech.challenge.exchange.service.impl;

import com.jayatech.challenge.exchange.domain.I18Constants;
import com.jayatech.challenge.exchange.domain.dto.Currency;
import com.jayatech.challenge.exchange.domain.dto.ExchangeRequest;
import com.jayatech.challenge.exchange.domain.dto.ExchangeResponse;
import com.jayatech.challenge.exchange.domain.dto.Transaction;
import com.jayatech.challenge.exchange.domain.model.Exchange;
import com.jayatech.challenge.exchange.exception.ExchangeException;
import com.jayatech.challenge.exchange.exception.NoSuchElementFoundException;
import com.jayatech.challenge.exchange.gateway.exchangerates.ExchangeRates;
import com.jayatech.challenge.exchange.gateway.exchangerates.dto.Charge;
import com.jayatech.challenge.exchange.gateway.exchangerates.dto.Rate;
import com.jayatech.challenge.exchange.repository.ExchangeRepository;
import com.jayatech.challenge.exchange.service.ExchangeService;
import com.jayatech.challenge.exchange.wrapper.ExchangeWrapper;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InMemoryExchangeService implements ExchangeService {
    private static final Logger LOGGER = Logger.getLogger(InMemoryExchangeService.class);

    private final ExchangeRepository repository;
    private final MessageSource messageSource;
    private final ExchangeRates rates;

    @Override
    public ExchangeResponse makeConversion(ExchangeRequest exchangeRequest) {
        ExchangeResponse exchangeResponse;
        try {
            Charge charge = obtainRate(exchangeRequest.getChange().getFrom(), exchangeRequest.getChange().getTo());
            exchange(exchangeRequest.getChange(), charge);
            Transaction transaction = loadConversion(exchangeRequest, charge);

            exchangeResponse = new ExchangeResponse(exchangeRequest.getUserID(),
                    exchangeRequest.getChange(), transaction);

        } catch (ExchangeException exception) {
            LOGGER.error(exception);
            throw new ExchangeException(getLocalMessage(I18Constants.NO_TRANSACTION_FOUND.getKey(), exception.getMessage()));
        }

        return exchangeResponse;
    }

    private Transaction loadConversion(ExchangeRequest exchangeRequest, Charge rate) {
        Transaction transaction = new Transaction();
        try {
            Exchange exchange = new Exchange();
            exchange.setCurrencyFrom(exchangeRequest.getChange().getFrom());
            exchange.setCurrencyTo(exchangeRequest.getChange().getTo());
            exchange.setValueFrom(exchangeRequest.getChange().getValue());
            exchange.setValueTo(exchangeRequest.getChange().getChange());
            exchange.setUserId(exchangeRequest.getUserID());
            exchange.setBase(rate.getRateBase());
            exchange.setRate(rate.getRateTo());
            exchange.setDateTime(LocalDateTime.now());

            exchange = repository.save(exchange);
            LOGGER.info(exchange);
            transaction.setDateTime(exchange.getDateTime());
            transaction.setId(exchange.getId().toString());
            transaction.setRate(rate.getRateFrom());
            LOGGER.info(transaction);
        } catch (ExchangeException exception) {
            LOGGER.error(exception);
            throw new ExchangeException(getLocalMessage(I18Constants.NO_TRANSACTION_FOUND.getKey(), exception.getMessage()));
        }

        return transaction;
    }

    private void exchange(Currency change, Charge rate) {
        try {
            double changeFrom = change.getValue() / rate.getRateFrom();
            double changeTo = changeFrom * rate.getRateTo();
            change.setChange(changeTo);
            LOGGER.info(change.getChange());
        } catch (ExchangeException exception) {
            LOGGER.error(exception);
            throw new ExchangeException(getLocalMessage(I18Constants.NO_TRANSACTION_FOUND.getKey(), exception.getMessage()));
        }
    }

    private Charge obtainRate(String from, String to) {
        Charge charge = new Charge();
        HashMap<String, Double> hashMapRates;
        try {
            Rate rate = rates.makeRatesByCurrency();
            LOGGER.info(rate);
            hashMapRates = ExchangeWrapper.wrapServiceToMap(rate.getRates());
            charge.setRateFrom(hashMapRates.get(from));
            charge.setRateTo(hashMapRates.get(to));
            charge.setRateBase("EUR");
        } catch (ExchangeException exception) {
            LOGGER.error(exception);
            throw new ExchangeException(getLocalMessage(I18Constants.NO_TRANSACTION_FOUND.getKey(), exception.getMessage()));
        }
        return charge;
    }

    public List<ExchangeResponse> findTransactionByUserId(String userId) {
        List<ExchangeResponse> exchangeResponses = new ArrayList<>();
        List<Exchange> exchanges = repository.findByUserId(userId)
                .stream()
                .map(Exchange::of)
                .collect(Collectors.toList());

        for (Exchange exchange :
                exchanges) {

            Currency currency = new Currency();
            currency.setChange(exchange.getValueTo());
            currency.setValue(exchange.getValueFrom());
            currency.setFrom(exchange.getCurrencyFrom());
            currency.setTo(exchange.getCurrencyTo());

            Transaction transaction = new Transaction();
            transaction.setRate(exchange.getRate());
            transaction.setId(exchange.getId().toString());
            transaction.setDateTime(exchange.getDateTime());

            ExchangeResponse exchangeResponse = new ExchangeResponse(exchange.getUserId(),currency, transaction);
            exchangeResponses.add(exchangeResponse);
        }

        if (exchangeResponses.size() == 0)
            throw new NoSuchElementFoundException(getLocalMessage(I18Constants.NO_TRANSACTION_FOUND.getKey(), userId));

        return exchangeResponses;
    }

    private String getLocalMessage(String key, String... params) {
        return messageSource.getMessage(key,
                params,
                Locale.ENGLISH);
    }
}
