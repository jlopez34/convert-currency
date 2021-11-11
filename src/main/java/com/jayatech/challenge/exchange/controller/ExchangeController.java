package com.jayatech.challenge.exchange.controller;

import com.jayatech.challenge.exchange.domain.dto.ExchangeRequest;
import com.jayatech.challenge.exchange.domain.dto.ExchangeResponse;
import com.jayatech.challenge.exchange.exception.ResourceNotFoundException;
import com.jayatech.challenge.exchange.service.ExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/exchange")
@AllArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;

    @PostMapping(value = "/convert")
    @ResponseStatus(HttpStatus.OK)
    public ExchangeResponse convertCurrency(@RequestBody @Validated ExchangeRequest exchangeRequest) {
        ExchangeResponse exchangeResponse = exchangeService.makeConversion(exchangeRequest);
        return exchangeResponse;
    }

    @GetMapping(value = "/transactions/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ExchangeResponse> findTransactionByUser(@PathVariable @Validated String userId) {
        List<ExchangeResponse> transactions = exchangeService.findTransactionByUserId(userId);
        if (transactions == null || transactions.isEmpty()) {
            throw new ResourceNotFoundException(userId);
        }
        return transactions;
    }

}

