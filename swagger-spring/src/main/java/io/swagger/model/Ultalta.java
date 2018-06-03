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
 * Ultalta
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-02T16:33:50.882Z")

public class Ultalta   {
  @JsonProperty("empresa")
  private String empresa = null;

  @JsonProperty("centro")
  private String centro = null;

  @JsonProperty("producto")
  private String producto = null;

  public Ultalta empresa(String empresa) {
    this.empresa = empresa;
    return this;
  }

  /**
   * Get empresa
   * @return empresa
  **/
  @ApiModelProperty(example = "0049", required = true, value = "")
  @NotNull


  public String getEmpresa() {
    return empresa;
  }

  public void setEmpresa(String empresa) {
    this.empresa = empresa;
  }

  public Ultalta centro(String centro) {
    this.centro = centro;
    return this;
  }

  /**
   * Get centro
   * @return centro
  **/
  @ApiModelProperty(example = "1999", required = true, value = "")
  @NotNull


  public String getCentro() {
    return centro;
  }

  public void setCentro(String centro) {
    this.centro = centro;
  }

  public Ultalta producto(String producto) {
    this.producto = producto;
    return this;
  }

  /**
   * Get producto
   * @return producto
  **/
  @ApiModelProperty(example = "480", required = true, value = "")
  @NotNull


  public String getProducto() {
    return producto;
  }

  public void setProducto(String producto) {
    this.producto = producto;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ultalta ultalta = (Ultalta) o;
    return Objects.equals(this.empresa, ultalta.empresa) &&
        Objects.equals(this.centro, ultalta.centro) &&
        Objects.equals(this.producto, ultalta.producto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(empresa, centro, producto);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ultalta {\n");
    
    sb.append("    empresa: ").append(toIndentedString(empresa)).append("\n");
    sb.append("    centro: ").append(toIndentedString(centro)).append("\n");
    sb.append("    producto: ").append(toIndentedString(producto)).append("\n");
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

