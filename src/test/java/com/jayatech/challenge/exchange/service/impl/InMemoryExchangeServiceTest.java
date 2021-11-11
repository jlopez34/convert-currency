package com.jayatech.challenge.exchange.service.impl;

import com.jayatech.challenge.exchange.gateway.exchangerates.ExchangeRates;
import com.jayatech.challenge.exchange.service.ExchangeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class InMemoryExchangeServiceTest {

    @Autowired
    ExchangeRates exchangeRates;

    @Autowired
    ExchangeService exchangeService;

    @Test
    void makeConversion() {
    }

    @Test
    void findTransactionByUserId() {
    }
}