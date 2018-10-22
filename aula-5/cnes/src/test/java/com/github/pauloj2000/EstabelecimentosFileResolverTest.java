package com.github.augustomoura;

import com.github.augustomoura.cnes.EstabelecimentosFileResolver;
import com.github.augustomoura.cnes.util.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

class EstabelecimentosFileResolverTest {

  private static final String SAMPLE_BASE_DADOS_PATH =
      "/sample-base-dados.zip";

  private static final String EXPECTED_JSON_RESULT_PATH =
      "/expected-estabelecimentos-info.json";

  @Test
  void deveResolverTodosEstabelecimentosDeUrlEEscreverEmJsonCorretamente() throws IOException {
    final URL baseDadosUrl = getClass().getResource(SAMPLE_BASE_DADOS_PATH);
    final ByteArrayOutputStream out = new ByteArrayOutputStream();

    final EstabelecimentosFileResolver resolver =
        new EstabelecimentosFileResolver(baseDadosUrl, out);

    resolver.resolveAndWrite();

    final String expectedContent = IOUtils.toText(
        getClass().getResourceAsStream(EXPECTED_JSON_RESULT_PATH)
    );

    Assertions.assertEquals(expectedContent, new String(out.toByteArray()));
  }

}
