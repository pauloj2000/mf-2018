package com.github.augustomoura.basedados;

import com.github.augustomoura.cnes.basedados.EstabelecimentosCnesInputStream;
import com.github.augustomoura.cnes.util.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.zip.ZipInputStream;

class EstabelecimentosCnesInputStreamTest {

  private static final String BASE_DADOS_ZIP_FILE_PATH =
      "/sample-base-dados.zip";

  private static final String ESTABELECIMENTOS_FILE_PATH =
      "/sample-base-estabelecimentos.csv";

  @Test
  void deveEncontrarOArquivoCorreto() throws IOException {
    final String expectedFileContent = IOUtils.toText(
        getClass().getResourceAsStream(ESTABELECIMENTOS_FILE_PATH));

    final ZipInputStream baseDadosIn = new ZipInputStream(
        getClass().getResourceAsStream(BASE_DADOS_ZIP_FILE_PATH));

    final EstabelecimentosCnesInputStream in =
        new EstabelecimentosCnesInputStream(baseDadosIn);

    Assertions.assertEquals(expectedFileContent, IOUtils.toText(in));
  }

}
