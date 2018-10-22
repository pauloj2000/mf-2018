package com.github.augustomoura.basedados;

import com.github.augustomoura.cnes.basedados.CnesEstabelecimentoCsvParser;
import com.github.augustomoura.cnes.basedados.Estabelecimento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class CnesEstabelecimentoCsvParserTest {

  private static final String SAMPLE_ESTABELECIMENTOS_CSV =
      "/sample-base-estabelecimentos.csv";

  @Test
  void deveLerParsearArquivoCorretamente() {
    final Reader reader = new InputStreamReader(
        getClass().getResourceAsStream(SAMPLE_ESTABELECIMENTOS_CSV));

    final CnesEstabelecimentoCsvParser parser = new CnesEstabelecimentoCsvParser(reader);

    final Iterator<Estabelecimento> iterator = parser.iterator();

    final List<Estabelecimento> estabelecimentos = new ArrayList<>(3);

    int i = 0;
    while (iterator.hasNext() && i++ < 3) {
      estabelecimentos.add(iterator.next());
    }

    Assertions.assertEquals(3, estabelecimentos.size());

    final Estabelecimento expectedFirstEstabelecimento = new Estabelecimento();
    expectedFirstEstabelecimento.setCodigo("9093133");
    expectedFirstEstabelecimento.setRazaoSocial("ESTELA REGINA EIDT");
    expectedFirstEstabelecimento.setLatitude("");
    expectedFirstEstabelecimento.setLongitude("");

    Assertions.assertEquals(expectedFirstEstabelecimento, estabelecimentos.get(0));
  }

}
