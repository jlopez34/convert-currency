package com.jayatech.challenge.exchange.gateway.exchangerates.dto;

import java.io.Serializable;

public class Rate implements Serializable {

    private String currency;
    private float tax;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

}
