package com.jayatech.challenge.exchange.domain.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Setter
@Getter
public class ExchangeRequest {

    @NotNull
    private Currency change;

    @NotNull
    @NotEmpty
    private String userID;

    public ExchangeRequest change(Currency change) {
        this.change = change;
        return this;
    }

    public ExchangeRequest userID(String userID) {
        this.userID = userID;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExchangeRequest exchangeRequest = (ExchangeRequest) o;
        return Objects.equals(this.change, exchangeRequest.change) &&
                Objects.equals(this.userID, exchangeRequest.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(change, userID);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExchangeRequest {\n");

        sb.append("    change: ").append(toIndentedString(change)).append("\n");
        sb.append("    userID: ").append(toIndentedString(userID)).append("\n");
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

