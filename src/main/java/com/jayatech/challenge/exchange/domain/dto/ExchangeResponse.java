package com.jayatech.challenge.exchange.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
public class ExchangeResponse {

    private String userID;

    private Currency currency;

    private Transaction transaction;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExchangeResponse exchangeResponse = (ExchangeResponse) o;
        return Objects.equals(this.userID, exchangeResponse.userID) &&
                Objects.equals(this.currency, exchangeResponse.currency) &&
                Objects.equals(this.transaction, exchangeResponse.transaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, currency, transaction);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExchangeResponse {\n");

        sb.append("    userID: ").append(toIndentedString(userID)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("    transaction: ").append(toIndentedString(transaction)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

