package com.jayatech.challenge.exchange.service;

import com.jayatech.challenge.exchange.dto.ExchangeRequest;
import com.jayatech.challenge.exchange.dto.ExchangeResponse;

import java.util.List;

public interface ExchangeService {
    ExchangeResponse makeConversion(ExchangeRequest exchangeRequest);
    List<ExchangeResponse> findTransactionByUserId(String userId);
}
