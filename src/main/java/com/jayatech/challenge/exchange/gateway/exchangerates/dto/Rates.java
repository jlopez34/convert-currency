package com.jayatech.challenge.exchange.gateway.exchangerates.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Rates implements Serializable {

private boolean success;
private Timestamp timestamp;
private String base;
private String date;
private List<Rate> rates;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
