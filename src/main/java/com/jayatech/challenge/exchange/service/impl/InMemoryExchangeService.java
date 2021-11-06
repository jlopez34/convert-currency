package com.jayatech.challenge.exchange.service.impl;

import com.jayatech.challenge.exchange.dto.ExchangeDto;
import com.jayatech.challenge.exchange.gateway.exchangerates.ExchangeRates;
import com.jayatech.challenge.exchange.model.ExchangeRequest;
import com.jayatech.challenge.exchange.model.ExchangeResponse;
import com.jayatech.challenge.exchange.repository.ExchangeRepository;
import com.jayatech.challenge.exchange.service.ExchangeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InMemoryExchangeService implements ExchangeService {
    private static final Logger LOGGER = Logger.getLogger(InMemoryExchangeService.class);

    @Autowired
    private ExchangeRepository repository;

    @Autowired
    private ExchangeRates rates;

    @Override
    public ExchangeResponse makeConversion(ExchangeRequest exchangeRequest) {
        ExchangeResponse exchangeResponse = null;
        try {
        }catch (Exception exception){
            LOGGER.error(exception);
        }
        return exchangeResponse;
    }

    @Override
    public List<ExchangeResponse> obtainTransaction(String userId) {
        List<ExchangeDto> exchangeDtoList = repository.findByUserId(userId);
        //TODO wrapper
        return null;
    }
}
