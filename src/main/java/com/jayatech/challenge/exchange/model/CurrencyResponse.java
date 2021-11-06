package com.jayatech.challenge.exchange.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * CurrencyResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-05T14:36:41.498Z")
public class CurrencyResponse {
  @SerializedName("from")
  private String from = null;

  @SerializedName("value")
  private Float value = null;

  @SerializedName("to")
  private String to = null;

  @SerializedName("change")
  private Float change = null;

  public CurrencyResponse from(String from) {
    this.from = from;
    return this;
  }

   /**
   * Get from
   * @return from
  **/
  @ApiModelProperty(example = "USD", value = "")
  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public CurrencyResponse value(Float value) {
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(example = "100.0", value = "")
  public Float getValue() {
    return value;
  }

  public void setValue(Float value) {
    this.value = value;
  }

  public CurrencyResponse to(String to) {
    this.to = to;
    return this;
  }

   /**
   * Get to
   * @return to
  **/
  @ApiModelProperty(example = "BRL", value = "")
  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public CurrencyResponse change(Float change) {
    this.change = change;
    return this;
  }

   /**
   * Get change
   * @return change
  **/
  @ApiModelProperty(example = "100.0", value = "")
  public Float getChange() {
    return change;
  }

  public void setChange(Float change) {
    this.change = change;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CurrencyResponse currencyResponse = (CurrencyResponse) o;
    return Objects.equals(this.from, currencyResponse.from) &&
        Objects.equals(this.value, currencyResponse.value) &&
        Objects.equals(this.to, currencyResponse.to) &&
        Objects.equals(this.change, currencyResponse.change);
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

