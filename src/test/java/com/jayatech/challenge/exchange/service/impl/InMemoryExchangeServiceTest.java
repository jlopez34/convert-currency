package com.jayatech.challenge.exchange.service.impl;

import com.jayatech.challenge.exchange.domain.dto.Currency;
import com.jayatech.challenge.exchange.domain.dto.ExchangeRequest;
import com.jayatech.challenge.exchange.domain.dto.ExchangeResponse;
import com.jayatech.challenge.exchange.domain.model.Exchange;
import com.jayatech.challenge.exchange.repository.ExchangeRepository;
import com.jayatech.challenge.exchange.service.ExchangeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InMemoryExchangeServiceTest {

    @Autowired
    ExchangeRepository repository;

    @Autowired
    ExchangeService exchangeService;

    private ExchangeRequest createRequest(){
        ExchangeRequest exchangeRequest = new ExchangeRequest();

        Currency currency = new Currency();
        currency.setFrom("USD");
        currency.setValue(100d);
        currency.setTo("CLP");

        exchangeRequest.setUserID("jlopez");
        exchangeRequest.setChange(currency);

        return exchangeRequest;
    }

    private Exchange createExchange(){
        Exchange exchange = new Exchange();
        exchange.setRate(1.54);
        exchange.setDateTime(LocalDateTime.now());
        exchange.setBase("EUR");
        exchange.setCurrencyFrom("USD");
        exchange.setCurrencyTo("CLP");
        exchange.setValueFrom(100);
        exchange.setValueTo(645.454545);
        exchange.setUserId("jlopez");

        return exchange;
    }

    @Test
    public void shouldReturnConversion() {
        ExchangeRequest request = createRequest();
        ExchangeResponse response = exchangeService.makeConversion(request);

        assertNotNull(response);
        assertEquals("jlopez", response.getUserID());
        assertEquals(Double.valueOf(79441.01049565077), response.getCurrency().getChange());
    }

    @Test
    public void shouldReturnTransactionsByUserId() {

        //Exchange exchange = repository.save(createExchange());
        List<ExchangeResponse> response = exchangeService.findTransactionByUserId(createExchange().getUserId());

        assertNotNull(response);
        assertEquals("jlopez", response.get(0).getUserID());
        assertTrue(response.size() > 0);
    }
}