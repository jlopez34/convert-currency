package com.jayatech.challenge.exchange.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
public class Currency implements Serializable {

    @NotNull
    @NotBlank
    private String from;

    @NotNull
    private Double value;

    @NotNull
    @NotBlank
    private String to;

    private Double change;

    public Currency from(String from) {
        this.from = from;
        return this;
    }

    public Currency value(Double value) {
        this.value = value;
        return this;
    }


    public Currency to(String to) {
        this.to = to;
        return this;
    }

    public Currency change(Double change) {
        this.change = change;
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
        Currency currency = (Currency) o;
        return Objects.equals(this.from, currency.from) &&
                Objects.equals(this.value, currency.value) &&
                Objects.equals(this.to, currency.to) &&
                Objects.equals(this.change, currency.change);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, value, to, change);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CurrencyResponse {\n");

        sb.append("    from: ").append(toIndentedString(from)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    to: ").append(toIndentedString(to)).append("\n");
        sb.append("    change: ").append(toIndentedString(change)).append("\n");
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

