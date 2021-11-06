package com.jayatech.challenge.exchange.controller;

import com.jayatech.challenge.exchange.gateway.exchangerates.impl.ExchangeRatesImpl;
import com.jayatech.challenge.exchange.model.ExchangeRequest;
import com.jayatech.challenge.exchange.model.ExchangeResponse;
import com.jayatech.challenge.exchange.service.ExchangeService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

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
    @ResponseStatus(HttpStatus.CREATED)
    public EntityResponse<ExchangeResponse> convertCurrency(@RequestBody ExchangeRequest exchangeRequest) {
        return null;
    }
}
