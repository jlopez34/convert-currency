package com.jayatech.challenge.exchange.dto;

import com.opengamma.strata.collect.ArgChecker;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ExchangeDto implements Serializable {

    private Long id;

    private String userId;

    private String currencyFrom;

    private float valueFrom;

    private String currencyTo;

    private float valueTo;

    private float rate;

    private LocalDateTime dateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public float getValueFrom() {
        return valueFrom;
    }

    public void setValueFrom(float valueFrom) {
        this.valueFrom = valueFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public float getValueTo() {
        return valueTo;
    }

    public void setValueTo(float valueTo) {
        this.valueTo = valueTo;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public ExchangeDto toEntity() {
        ExchangeDto store = new ExchangeDto();
        BeanUtils.copyProperties(this, store);
        return store;
    }

    public static ExchangeDto of(ExchangeDto exchange) {
        ArgChecker.notNull(exchange, "exchange");
        ExchangeDto dto = new ExchangeDto();
        BeanUtils.copyProperties(exchange, dto);
        return dto;
    }
}
