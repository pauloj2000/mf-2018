package com.github.augustomoura.cnes;

import com.github.augustomoura.cnes.excecoes.ParametroInvalido;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

public class AppArguments {

  private URL inUrl = null;
  private Path outUrl = Paths.get("out.json");
  private boolean askingHelp = false;

  public AppArguments(final String[] args) {
    parseArgs(args);
  }

  public URL getInUrl() {
    return inUrl;
  }

  public Path getOutUrl() {
    return outUrl;
  }

  public boolean isAskingHelp() {
    return askingHelp;
  }

  private void parseArgs(final String[] args) {
    final Iterator<String> it = Arrays.asList(args).iterator();

    String arg;
    while (it.hasNext()) {
      arg = it.next();

      if ("--out".equals(arg) || "-o".equals(arg)) {
        if (it.hasNext()) {
          this.outUrl = Paths.get(it.next());
        } else {
          throw new ParametroInvalido(
              "Parametro de arquivo de saída incompleto");
        }

        continue;
      }

      if ("--help".equals(arg) || "-h".equals(arg)) {
        this.askingHelp = true;
        continue;
      }

      if (this.inUrl == null) {
        final Optional<URL> maybeUrl = parseUrl(arg);

        if (maybeUrl.isPresent()) {
          this.inUrl = maybeUrl.get();
          continue;
        }
      }

      throw new ParametroInvalido(String.format("Parametro %s inválido", arg));
    }

    if (this.inUrl == null) {
      throw new ParametroInvalido("Não foi passada a url do arquivo a ser baixado");
    }
  }

  private static Optional<URL> parseUrl(final String txt) {
    try {
      return Optional.of(new URL(txt));
    } catch (final MalformedURLException e) {
      try {
        return Optional.of(Paths.get(txt).toUri().toURL());
      } catch (final MalformedURLException ignore) {
        return Optional.empty();
      }
    }
  }
}
