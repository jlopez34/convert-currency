package com.jayatech.challenge.exchange.model;

import com.opengamma.strata.collect.ArgChecker;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Exchange implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String userId;

    @Column
    private String currencyFrom;

    @Column
    private float valueFrom;

    @Column
    private String currencyTo;

    @Column
    private float valueTo;

    @Column
    private float rate;

    @Column
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

    public Exchange toEntity() {
        Exchange store = new Exchange();
        BeanUtils.copyProperties(this, store);
        return store;
    }

    public static Exchange of(Exchange exchange) {
        ArgChecker.notNull(exchange, "exchange");
        Exchange dto = new Exchange();
        BeanUtils.copyProperties(exchange, dto);
        return dto;
    }
}
