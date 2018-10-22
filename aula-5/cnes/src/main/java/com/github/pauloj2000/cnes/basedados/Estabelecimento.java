package com.github.augustomoura.cnes.basedados;

import java.util.Objects;

public class Estabelecimento {

  private String codigo;
  private String razaoSocial;
  private String latitude;
  private String longitude;


  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getRazaoSocial() {
    return razaoSocial;
  }

  public void setRazaoSocial(String razaoSocial) {
    this.razaoSocial = razaoSocial;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) { return true; }
    if (o == null || getClass() != o.getClass()) { return false; }
    Estabelecimento that = (Estabelecimento) o;
    return Objects.equals(getCodigo(), that.getCodigo()) &&
        Objects.equals(getRazaoSocial(), that.getRazaoSocial()) &&
        Objects.equals(getLatitude(), that.getLatitude()) &&
        Objects.equals(getLongitude(), that.getLongitude());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCodigo(), getRazaoSocial(), getLatitude(), getLongitude());
  }

  @Override
  public String toString() {
    return "Estabelecimento{" +
        "codigo='" + codigo + '\'' +
        ", razaoSocial='" + razaoSocial + '\'' +
        ", latitude='" + latitude + '\'' +
        ", longitude='" + longitude + '\'' +
        '}';
  }
}
