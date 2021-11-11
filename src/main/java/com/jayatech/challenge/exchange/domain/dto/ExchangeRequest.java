package com.jayatech.challenge.exchange.domain.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * ExchangeRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-05T14:36:41.498Z")
public class ExchangeRequest {
  @SerializedName("change")
  private Currency change = null;

  @SerializedName("userID")
  private String userID = null;

  public ExchangeRequest change(Currency change) {
    this.change = change;
    return this;
  }

   /**
   * Get change
   * @return change
  **/
  @ApiModelProperty(value = "")
  public Currency getChange() {
    return change;
  }

  public void setChange(Currency change) {
    this.change = change;
  }

  public ExchangeRequest userID(String userID) {
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

