package com.jayatech.challenge.exchange.gateway.exchangerates;

import com.jayatech.challenge.exchange.gateway.exchangerates.dto.Rate;

public interface ExchangeRates {

    Rate makeRatesByCurrency();
}
