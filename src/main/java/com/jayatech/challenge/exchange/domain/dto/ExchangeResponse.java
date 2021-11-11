package com.jayatech.challenge.exchange.domain.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * ExchangeResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-05T14:36:41.498Z")
public class ExchangeResponse {
  @SerializedName("userID")
  private String userID = null;

  @SerializedName("currency")
  private Currency currency = null;

  @SerializedName("transaction")
  private Transaccion transaction = null;

  public ExchangeResponse userID(String userID) {
    this.userID = userID;
    return this;
  }

   /**
   * Get userID
   * @return userID
  **/
  @ApiModelProperty(example = "12312312", value = "")
  public String getUserID() {
    return userID;
  }

  public void setUserID(String userID) {
    this.userID = userID;
  }

  public ExchangeResponse currency(Currency currency) {
    this.currency = currency;
    return this;
  }

   /**
   * Get currency
   * @return currency
  **/
  @ApiModelProperty(value = "")
  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public ExchangeResponse transaction(Transaccion transaction) {
    this.transaction = transaction;
    return this;
  }

   /**
   * Get transaction
   * @return transaction
  **/
  @ApiModelProperty(value = "")
  public Transaccion getTransaction() {
    return transaction;
  }

  public void setTransaction(Transaccion transaction) {
    this.transaction = transaction;
  }


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

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

