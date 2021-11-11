package com.jayatech.challenge.exchange.gateway.exchangerates.impl;

import com.jayatech.challenge.exchange.config.ConfigurationProperties;
import com.jayatech.challenge.exchange.exception.ExchangeRateAPIException;
import com.jayatech.challenge.exchange.gateway.exchangerates.ExchangeRates;
import com.jayatech.challenge.exchange.gateway.exchangerates.dto.Rate;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExchangeRatesImpl implements ExchangeRates {
    private static final Logger LOGGER = Logger.getLogger(ExchangeRatesImpl.class);

    private final ConfigurationProperties properties;

    public ExchangeRatesImpl(ConfigurationProperties properties) {
        this.properties = properties;
    }

    @Override
    public Rate makeRatesByCurrency() {
        Rate rate = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            rate = restTemplate.getForObject(properties.getRateEndPoint(), Rate.class);
        } catch (ExchangeRateAPIException exception) {
            LOGGER.error(exception);
            throw new ExchangeRateAPIException();
        }
        LOGGER.info("Rates ::::" + rate);
        return rate;
    }
}
