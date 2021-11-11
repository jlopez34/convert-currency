package com.jayatech.challenge.exchange.gateway.exchangerates.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Charge implements Serializable {

    private String rateBase;
    private double rateFrom;
    private double rateTo;

}
