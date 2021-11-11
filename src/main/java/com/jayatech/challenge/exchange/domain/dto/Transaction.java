package com.jayatech.challenge.exchange.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Setter
@Getter
public class Transaction {

  private String id = null;

  private Double rate = null;

  private LocalDateTime dateTime = null;

  public Transaction id(String id) {
    this.id = id;
    return this;
  }

  public Transaction rate(Double rate) {
    this.rate = rate;
    return this;
  }


  public Transaction dateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
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
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.id, transaction.id) &&
        Objects.equals(this.rate, transaction.rate) &&
        Objects.equals(this.dateTime, transaction.dateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, rate, dateTime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaccion {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
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

