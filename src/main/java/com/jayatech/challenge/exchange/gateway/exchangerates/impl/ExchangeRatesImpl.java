package com.jayatech.challenge.exchange.gateway.exchangerates.impl;

import com.jayatech.challenge.exchange.config.ConfigurationProperties;
import com.jayatech.challenge.exchange.gateway.exchangerates.ExchangeRates;
import com.jayatech.challenge.exchange.gateway.exchangerates.dto.Rates;
import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ExchangeRatesImpl implements ExchangeRates {
    private static final Logger LOGGER = Logger.getLogger(ExchangeRatesImpl.class);
    private final ConfigurationProperties properties;

    public ExchangeRatesImpl(ConfigurationProperties properties) {
        this.properties = properties;
    }

    @Override
    public List<Rates> makeRatesByCurrency(String currency) {
        List<Rates> rates = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            rates = restTemplate.getForObject(properties.getRateEndPoint(), List.class);
        } catch (Exception exception) {
            LOGGER.error(exception);
        }
        LOGGER.info("Rates ::::" + rates);
        return rates;
    }
}
