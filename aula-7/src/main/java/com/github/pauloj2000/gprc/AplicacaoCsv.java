package com.github.augustomoura;


import com.github.augustomoura.csv.InstituacaoReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AplicacaoCsv {

  private static final Logger LOGGER =
      LogManager.getLogger(AplicacaoCsv.class);

  private static final String DEFAULT_INSTITUICAO_URL =
      "http://repositorio.dados.gov.br/educacao/CADASTRO%20DAS%20IES_2011.csv";

  private static final char CSV_DELIMITER = ';';

  private static final int INSTITUICOES_DOC_COVER_OFFSET = 10;

  public static void main(final String[] args) {
    final URL url = parseUrlParam(args);

    try (
        final Reader urlFileReader = new BufferedReader(
            new InputStreamReader(url.openStream()));

        final InstituacaoReader instituacaoReader =
            new InstituacaoReader(urlFileReader, INSTITUICOES_DOC_COVER_OFFSET, CSV_DELIMITER)
    ) {
      final List<String> cabecalhos = instituacaoReader.getHeaders();
      final Map<String, Integer>

      for (
          String[] lines = instituacaoReader.nextLine();
          lines != null;
          lines = instituacaoReader.nextLine()
      ) {

      }

    } catch (final IOException e) {
      LOGGER.fatal("Erro ao tentar ler arquivo na url: " + url.getPath(), e);
    }
  }

  public static URL parseUrlParam(final String[] args) {
    final String urlText = args.length > 1 ? args[0] : null;

    if (urlText != null) {
      try {
        return new URL(urlText);
      } catch (final MalformedURLException e) {
        LOGGER.error("URL passada mal formada", e);
      }
    }

    LOGGER.info("Usando valor padrão para url: " + DEFAULT_INSTITUICAO_URL);

    try {
      return new URL(DEFAULT_INSTITUICAO_URL);
    } catch (final MalformedURLException ignore) {
      // Valor default é válido por contrato
      return null;
    }
  }

}
