package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UltaltaResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-12T09:12:54.608Z")

public class UltaltaResponse   {
  @JsonProperty("contrato")
  private String contrato = null;

  public UltaltaResponse contrato(String contrato) {
    this.contrato = contrato;
    return this;
  }

  /**
   * Get contrato
   * @return contrato
  **/
  @ApiModelProperty(example = "HHFKaks84nfafS12", value = "")


  public String getContrato() {
    return contrato;
  }

  public void setContrato(String contrato) {
    this.contrato = contrato;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UltaltaResponse ultaltaResponse = (UltaltaResponse) o;
    return Objects.equals(this.contrato, ultaltaResponse.contrato);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contrato);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UltaltaResponse {\n");
    
    sb.append("    contrato: ").append(toIndentedString(contrato)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

