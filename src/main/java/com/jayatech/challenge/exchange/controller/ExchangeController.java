package com.jayatech.challenge.exchange.controller;

import com.jayatech.challenge.exchange.controller.exception.ResourceNotFoundException;
import com.jayatech.challenge.exchange.dto.ExchangeRequest;
import com.jayatech.challenge.exchange.dto.ExchangeResponse;
import com.jayatech.challenge.exchange.service.ExchangeService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RestController
@RequestMapping("/exchange/")
public class ExchangeController {
    private static final Logger LOGGER = Logger.getLogger(ExchangeController.class);

    private final ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @PostMapping(value = "/convert")
    @ResponseStatus(HttpStatus.OK)
    public ExchangeResponse convertCurrency(@RequestBody ExchangeRequest exchangeRequest) {
        ExchangeResponse exchangeResponse = exchangeService.makeConversion(exchangeRequest);
        LOGGER.info(exchangeResponse);
        return exchangeResponse;
    }

    @GetMapping(value = "/transactions/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ExchangeResponse> findTransactionByUser(@PathVariable String userId) {
        List<ExchangeResponse> transactions = exchangeService.findTransactionByUserId(userId);
        if (transactions == null || transactions.isEmpty()) {
            LOGGER.error(transactions);
            throw new ResourceNotFoundException();
        }
        LOGGER.info(transactions);
        return transactions;
    }

}

