package com.github.augustomoura.cnes.basedados;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;

public class CnesEstabelecimentoCsvParser implements Iterable<Estabelecimento> {

  private static final CsvMapper csvMapper = new CsvMapper();
  private static final CsvSchema headerSchema = csvMapper.schemaWithHeader()
      .withColumnSeparator(';')
      .withQuoteChar('"');

  private final Reader reader;

  public CnesEstabelecimentoCsvParser(final Reader reader) {
    this.reader = reader;
  }

  @Override
  public EstabelecimentoFromMappingIterator iterator() {
    try {
      return new EstabelecimentoFromMappingIterator(getMappingIterator());
    } catch (final IOException e) {
      throw new RuntimeException("Erro ao instanciar iterador de estabelecimentos", e);
    }
  }

  private MappingIterator<Map<String, String>> getMappingIterator() throws IOException {
    return csvMapper.readerFor(Map.class)
        .with(headerSchema)
        .readValues(reader);
  }

  public static class EstabelecimentoFromMappingIterator implements Iterator<Estabelecimento>, Closeable {

    private static final String RAZAO_SOCIAL_HEADER = "NO_RAZAO_SOCIAL";
    private static final String CNES_HEADER = "CO_CNES";
    private static final String LATITUDE_HEADER = "NU_LATITUDE";
    private static final String LONGITUDE_HEADER = "NU_LONGITUDE";

    private final MappingIterator<Map<String, String>> iterator;

    private EstabelecimentoFromMappingIterator(MappingIterator<Map<String, String>> iterator) {
      this.iterator = iterator;
    }

    @Override
    public void close() {
      try {
        iterator.close();
      } catch (final IOException ignore) {
        // provavelmente já fechado
      }
    }

    @Override
    public boolean hasNext() {
      return iterator.hasNext();
    }

    @Override
    public Estabelecimento next() {
      final Map<String, String> csvEntry = iterator.next();

      final Estabelecimento estabelecimento = new Estabelecimento();
      estabelecimento.setCodigo(csvEntry.get(CNES_HEADER));
      estabelecimento.setRazaoSocial(csvEntry.get(RAZAO_SOCIAL_HEADER));
      estabelecimento.setLatitude(csvEntry.get(LATITUDE_HEADER));
      estabelecimento.setLongitude(csvEntry.get(LONGITUDE_HEADER));

      return estabelecimento;
    }
  }

}
