package com.jayatech.challenge.exchange.gateway.exchangerates;

import com.jayatech.challenge.exchange.gateway.exchangerates.dto.Rates;

import java.util.List;

public interface ExchangeRates {

    Rates makeRatesByCurrency(String currency);
}
