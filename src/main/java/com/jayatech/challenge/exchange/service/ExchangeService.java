package com.jayatech.challenge.exchange.service;

import com.jayatech.challenge.exchange.model.ExchangeRequest;
import com.jayatech.challenge.exchange.model.ExchangeResponse;

import java.util.List;

public interface ExchangeService {
    ExchangeResponse makeConversion(ExchangeRequest exchangeRequest);
    List<ExchangeResponse> obtainTransaction(String userId);
}
