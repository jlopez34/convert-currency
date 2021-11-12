package com.jayatech.challenge.exchange.gateway.exchangerates.impl;

import com.jayatech.challenge.exchange.gateway.exchangerates.ExchangeRates;
import com.jayatech.challenge.exchange.gateway.exchangerates.dto.Rate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExchangeRatesImplTest {

    @Autowired
    ExchangeRates exchangeRates;

    @Test
    public void shouldReturnRatesByCurrency() {
        Rate rate = exchangeRates.makeRatesByCurrency();
        assertNotNull(rate);
        assertNotNull(rate.getRates());
        assertTrue(rate.getRates().getAED() > 0);
    }
}