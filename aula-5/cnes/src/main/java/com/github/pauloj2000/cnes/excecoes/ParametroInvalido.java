package com.github.augustomoura.cnes.excecoes;

public class ParametroInvalido extends RuntimeException {

  public ParametroInvalido() {
  }

  public ParametroInvalido(String message) {
    super(message);
  }

  public ParametroInvalido(String message, Throwable cause) {
    super(message, cause);
  }

  public ParametroInvalido(Throwable cause) {
    super(cause);
  }
}
