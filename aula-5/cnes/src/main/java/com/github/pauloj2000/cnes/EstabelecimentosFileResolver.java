package com.github.augustomoura.cnes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.augustomoura.cnes.basedados.CnesEstabelecimentoCsvParser;
import com.github.augustomoura.cnes.basedados.Estabelecimento;
import com.github.augustomoura.cnes.basedados.EstabelecimentosCnesInputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipInputStream;

import static com.github.augustomoura.cnes.basedados.CnesEstabelecimentoCsvParser.EstabelecimentoFromMappingIterator;

public class EstabelecimentosFileResolver {

  private static final int INFO_LOG_BATCH_SIZE = 10000;
  private static final Logger logger =
      LogManager.getLogger(EstabelecimentosFileResolver.class);
  private static final ObjectMapper jsonMapper = new ObjectMapper();

  private final URL originUrl;
  private final OutputStream out;

  public EstabelecimentosFileResolver(URL originUrl, OutputStream out) {
    this.originUrl = originUrl;
    this.out = out;
  }

  public void resolveAndWrite() throws IOException {
    final ZipInputStream urlZipIn = new ZipInputStream(originUrl.openStream());

    try (
        final InputStream inEstabelecimentoCsv = new EstabelecimentosCnesInputStream(urlZipIn)
    ) {
      final CnesEstabelecimentoCsvParser parser =
          new CnesEstabelecimentoCsvParser(new InputStreamReader(inEstabelecimentoCsv));

      logger.info("Iniciando resolução de estabelecimentos");

      final List<Estabelecimento> estabelecimentos =
          acumularEstabelecimentos(parser);

      logger.info("Resolução de estabelecimentos concluída");
      logger.info("Inciando escrita de valores");

      jsonMapper.writeValue(out, estabelecimentos);

      logger.info("Escrita de estabelecimentos concluída");
    }
  }

  private List<Estabelecimento> acumularEstabelecimentos(
      final CnesEstabelecimentoCsvParser parser
  ) {
    final List<Estabelecimento> estabelecimentos = new LinkedList<>();

    int i = 0;

    try (final EstabelecimentoFromMappingIterator iterator = parser.iterator()) {
      while (iterator.hasNext()) {
        estabelecimentos.add(iterator.next());

        if (i++ >= INFO_LOG_BATCH_SIZE) {
          i = 0;
          logger.info(String.format("Mais %d estabelecimentos resolvidos", INFO_LOG_BATCH_SIZE));
        }
      }
    }

    return estabelecimentos;
  }
}
