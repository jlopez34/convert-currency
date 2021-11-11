package com.jayatech.challenge.exchange.gateway.exchangerates.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Rate implements Serializable {

    private boolean success;
    private int timestamp;
    private String base;
    private String date;
    private Rates rates;

}
