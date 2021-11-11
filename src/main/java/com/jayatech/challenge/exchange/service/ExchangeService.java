package com.jayatech.challenge.exchange.service;

import com.jayatech.challenge.exchange.domain.dto.ExchangeRequest;
import com.jayatech.challenge.exchange.domain.dto.ExchangeResponse;
import com.jayatech.challenge.exchange.exception.ExchangeException;

import java.util.List;

public interface ExchangeService {
    ExchangeResponse makeConversion(ExchangeRequest exchangeRequest) throws ExchangeException;
    List<ExchangeResponse> findTransactionByUserId(String userId);
}
