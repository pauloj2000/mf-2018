package com.github.augustomoura.util;

import com.github.augustomoura.cnes.util.IOUtils;
import com.github.augustomoura.cnes.util.ZipFileFilterInputStream;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZipFileFilterInputStreamTest {

  private static final String EXAMPLE_ZIP_RESOURCE_PATH = "/simple-example.zip";

  @Test
  void deveLerApenasConteudoArquivoSolicitado() throws IOException {
    final String fileNameToSearch = "foo.txt";
    final String expectedFileContent = "foo\n";

    final ZipInputStream exampleFileIn = new ZipInputStream(
        getClass().getResourceAsStream(EXAMPLE_ZIP_RESOURCE_PATH));

    final ZipFileFilterInputStream in =
        new ZipFileFilterInputStream(exampleFileIn) {
          protected boolean zipEntryMatches(final ZipEntry entry) {
            return entry.getName().equals(fileNameToSearch);
          }
        };

    assertEquals(expectedFileContent, IOUtils.toText(in));
  }

}
