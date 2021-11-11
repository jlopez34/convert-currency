package com.jayatech.challenge.exchange.gateway.exchangerates.dto;

import java.io.Serializable;

public class Charge implements Serializable {
    private String rateBase;
    private double rateFrom;
    private double rateTo;

    public String getRateBase() {
        return rateBase;
    }

    public void setRateBase(String rateBase) {
        this.rateBase = rateBase;
    }

    public double getRateFrom() {
        return rateFrom;
    }

    public void setRateFrom(double rateFrom) {
        this.rateFrom = rateFrom;
    }

    public double getRateTo() {
        return rateTo;
    }

    public void setRateTo(double rateTo) {
        this.rateTo = rateTo;
    }
}
