package com.jayatech.challenge.exchange.controller;

import com.jayatech.challenge.exchange.domain.dto.Currency;
import com.jayatech.challenge.exchange.domain.dto.ExchangeRequest;
import com.jayatech.challenge.exchange.domain.dto.ExchangeResponse;
import com.jayatech.challenge.exchange.domain.dto.Transaction;
import com.jayatech.challenge.exchange.service.ExchangeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ExchangeController.class)
public class ExchangeControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    ExchangeService exchangeService;

    @Before
    public void setUp() {
        Mockito.reset(exchangeService);
    }

    @Test
    public void shouldConvertCurrency() throws Exception {
        String json = "{\n\"change\": {\n\"from\": \"USD\",\n\"value\": 125,\n\"to\": \"BRL\"\n},\n\"userID\": \"jlopez\"\n}";

        ExchangeRequest exchangeRequest = new ExchangeRequest();
        Currency currency = new Currency();
        currency.setFrom("USD");
        currency.setValue(125d);
        currency.setTo("BRL");
        String userId = "jlopez";

        exchangeRequest.setChange(currency);
        exchangeRequest.setUserID(userId);


        Transaction transaction = new Transaction();
        transaction.setId("1");
        transaction.setRate(1.15d);
        transaction.setDateTime(LocalDateTime.now());

        currency.setChange(675.0755318647599d);

        ExchangeResponse exchangeResponse = new ExchangeResponse(userId, currency, transaction);

        when(exchangeService.makeConversion(exchangeRequest)).thenReturn(exchangeResponse);

        mockMvc.perform(post("/exchange/convert").accept(APPLICATION_JSON)
                .contentType(APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnTransactionsByUserId() throws Exception {
        String userId = "jlopez";
        Currency currency = new Currency();
        currency.setFrom("USD");
        currency.setValue(125d);
        currency.setTo("BRL");
        currency.setChange(675.0755318647599d);

        Transaction transaction = new Transaction();
        transaction.setId("1");
        transaction.setRate(1.15d);
        transaction.setDateTime(LocalDateTime.now());

        List<ExchangeResponse> exchangeResponseList = new ArrayList<>();
        ExchangeResponse exchangeResponse = new ExchangeResponse(userId, currency, transaction);
        exchangeResponseList.add(exchangeResponse);

        when(exchangeService.findTransactionByUserId(userId)).thenReturn(exchangeResponseList);

        mockMvc.perform(get("/exchange/transactions/jlopez").accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("[0].userID", is(userId)));

    }
}