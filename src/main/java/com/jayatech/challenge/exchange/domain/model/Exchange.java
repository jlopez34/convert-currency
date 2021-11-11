package com.jayatech.challenge.exchange.domain.model;

import com.opengamma.strata.collect.ArgChecker;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_exchanges")
public class Exchange implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column
    private String userId;

    @Column
    private String currencyFrom;

    @Column
    private double valueFrom;

    @Column
    private String currencyTo;

    @Column
    private double valueTo;

    @Column
    private double rate;

    @Column
    private String base;

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

    public double getValueFrom() {
        return valueFrom;
    }

    public void setValueFrom(double valueFrom) {
        this.valueFrom = valueFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public double getValueTo() {
        return valueTo;
    }

    public void setValueTo(double valueTo) {
        this.valueTo = valueTo;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
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
