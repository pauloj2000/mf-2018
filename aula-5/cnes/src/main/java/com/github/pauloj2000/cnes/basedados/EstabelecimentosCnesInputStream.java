package com.github.augustomoura.cnes.basedados;

import com.github.augustomoura.cnes.util.ZipFileFilterInputStream;

import java.io.IOException;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class EstabelecimentosCnesInputStream extends ZipFileFilterInputStream {

  private static final Pattern ESTABELECIMENTOS_FILE_PATTERN =
      Pattern.compile("^tbEstabelecimento\\d{6}\\.csv");

  public EstabelecimentosCnesInputStream(final ZipInputStream in) throws IOException {
    super(in);
  }

  @Override
  protected boolean zipEntryMatches(ZipEntry entry) {
    return ESTABELECIMENTOS_FILE_PATTERN.matcher(entry.getName()).matches();
  }

}
