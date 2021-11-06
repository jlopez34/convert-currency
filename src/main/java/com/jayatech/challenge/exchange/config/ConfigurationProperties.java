package com.jayatech.challenge.exchange.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationProperties {

    @Value("${service.rates.endpoint}")
    private String rateEndPoint;

    public String getRateEndPoint() {
        return rateEndPoint;
    }

    public void setRateEndPoint(String rateEndPoint) {
        this.rateEndPoint = rateEndPoint;
    }
}
