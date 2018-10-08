package com.github.augustomoura.csv;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InstituacaoReader implements AutoCloseable {

  private final CSVReader csvReader;

  private int offset;

  private boolean readHeader = false;

  private List<String> headers = Collections.emptyList();

  public InstituacaoReader(final Reader input, final int offset, final char csvDelimiter) {
    this.offset = Math.max(0, offset);
    this.csvReader = new CSVReaderBuilder(input)
        .withCSVParser(new CSVParser(csvDelimiter))
        .build();
  }

  public InstituacaoReader(final Reader input, final char csvDelimiter) {
    this(input, 0, csvDelimiter);
  }

  private void readHeadersIfNecessary() {
    if (readHeader) {
      return;
    }

    try {
      for (int i = 0; i < offset; i++) {
        csvReader.readNext();
      }

      headers = Collections.unmodifiableList(Arrays.asList(csvReader.readNext()));
    } catch (final Exception ignore) {
      // se der erro quando lendo offset não atrapalha em nada
    }
  }

  public String[] nextLine() throws IOException {
    readHeadersIfNecessary();
    return csvReader.readNext();
  }

  @Override
  public void close() throws IOException {
    csvReader.close();
  }

  public List<String> getHeaders() {
    readHeadersIfNecessary();
    return headers;
  }
}
