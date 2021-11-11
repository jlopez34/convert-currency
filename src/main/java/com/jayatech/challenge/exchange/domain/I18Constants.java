package com.jayatech.challenge.exchange.domain;

import lombok.Getter;

@Getter
public enum I18Constants {
    NO_TRANSACTION_FOUND("transaction.notFound"),
    ERROR_TRANSACTION("transaction.error");

    String key;
    I18Constants(String key) {
        this.key = key;
    }
}
