package com.jayatech.challenge.exchange.service.impl;

import com.jayatech.challenge.exchange.dto.Currency;
import com.jayatech.challenge.exchange.dto.ExchangeRequest;
import com.jayatech.challenge.exchange.dto.ExchangeResponse;
import com.jayatech.challenge.exchange.dto.Transaccion;
import com.jayatech.challenge.exchange.gateway.exchangerates.ExchangeRates;
import com.jayatech.challenge.exchange.gateway.exchangerates.dto.Rates;
import com.jayatech.challenge.exchange.model.Exchange;
import com.jayatech.challenge.exchange.repository.ExchangeRepository;
import com.jayatech.challenge.exchange.service.ExchangeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InMemoryExchangeService implements ExchangeService {
    private static final Logger LOGGER = Logger.getLogger(InMemoryExchangeService.class);


    private final ExchangeRepository repository;

    @Autowired
    private ExchangeRates rates;

    public InMemoryExchangeService(ExchangeRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExchangeResponse makeConversion(ExchangeRequest exchangeRequest) {
        ExchangeResponse exchangeResponse = null;
        try {
            float rate = obtainRate(exchangeRequest.getChange().getFrom(), exchangeRequest.getChange().getTo());
            exchange(exchangeRequest.getChange(), rate);
            Transaccion transaccion = loadConversion(exchangeRequest, rate);

            exchangeResponse = new ExchangeResponse();
            exchangeResponse.setCurrency(exchangeRequest.getChange());
            exchangeResponse.setUserID(exchangeRequest.getUserID());
            exchangeResponse.setTransaction(transaccion);

        } catch (Exception exception) {
            LOGGER.error(exception);
        }
        return exchangeResponse;
    }

    private Transaccion loadConversion(ExchangeRequest exchangeRequest, float rate) {
        Transaccion transaccion = null;
        try {
            Exchange exchange = new Exchange();
            exchange.setCurrencyFrom(exchangeRequest.getChange().getFrom());
            exchange.setCurrencyTo(exchangeRequest.getChange().getTo());
            exchange.setValueFrom(exchangeRequest.getChange().getValue());
            exchange.setValueTo(exchangeRequest.getChange().getChange());
            exchange.setUserId(exchangeRequest.getUserID());
            exchange.setRate(rate);
            exchange.setDateTime(LocalDateTime.now());

            exchange = repository.save(exchange);
            LOGGER.info(exchange);
            transaccion.setDateTime(exchange.getDateTime());
            transaccion.setId(exchange.getId().toString());
            transaccion.setRate(rate);
            LOGGER.info(transaccion);
        } catch (Exception exception) {
            LOGGER.error(exception);
        }

        return transaccion;
    }

    private void exchange(Currency change, float rate) {
        try {
            change.setChange(change.getValue() * rate);
            LOGGER.info(change.getChange());
        }catch (Exception exception){
            LOGGER.error(exception);
        }
    }

    private float obtainRate(String from, String to) {
        float currentRate = 0;
        try {
            Rates rate = rates.makeRatesByCurrency(from);
            LOGGER.info(rate);
            currentRate = rate.getRates().get(0).getTax();
        } catch (Exception exception) {
            LOGGER.error(exception);
        }
        return currentRate;
    }

    public List<ExchangeResponse> findTransactionByUserId(String userId) {
        List<ExchangeResponse> exchangeResponses = new ArrayList<>();
        List<Exchange> exchanges = repository.findByUserId(userId)
                .stream()
                .map(Exchange::of)
                .collect(Collectors.toList());

        for (Exchange exchange:
             exchanges) {
            ExchangeResponse exchangeResponse= new ExchangeResponse();
            exchangeResponse.setUserID(exchange.getUserId());

            Currency currency = new Currency();
            currency.setChange(exchange.getValueTo());
            currency.setValue(exchange.getValueFrom());
            currency.setFrom(exchange.getCurrencyFrom());
            currency.setTo(exchange.getCurrencyTo());
            exchangeResponse.setCurrency(currency);

            Transaccion transaccion = new Transaccion();
            transaccion.setRate(exchange.getRate());
            transaccion.setId(exchange.getId().toString());
            transaccion.setDateTime(exchange.getDateTime());
            exchangeResponse.setTransaction(transaccion);

            exchangeResponses.add(exchangeResponse);
        }

        return exchangeResponses;
    }

}
