package com.github.augustomoura.util;

import com.github.augustomoura.cnes.util.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

class IOUtilsTest {

  @Test
  void deveTransferirAsInformacoesCorretamente() throws IOException {
    final String textToBeTransfered = "Lorem ipsum, dolor sit amet";

    final ByteArrayInputStream in = new ByteArrayInputStream(textToBeTransfered.getBytes());
    final ByteArrayOutputStream out = new ByteArrayOutputStream();

    IOUtils.writeTo(in, out);

    Assertions.assertEquals(textToBeTransfered, new String(out.toByteArray()));
  }

  @Test
  void deveLerArquivoCorretamente() throws IOException {
    final String expectedText = "Foo";

    final InputStream in = new ByteArrayInputStream(expectedText.getBytes());

    Assertions.assertEquals(expectedText, IOUtils.toText(in));
  }

}
