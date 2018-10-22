package com.github.augustomoura.cnes.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final public class IOUtils {

  private static final int BUFFER_SIZE = 1024;

  private IOUtils() {
  }

  public static void writeTo(
      final InputStream in,
      final OutputStream out
  ) throws IOException {
    final byte[] buffer = new byte[BUFFER_SIZE];

    for (
        int len = in.read(buffer);
        len != -1;
        len = in.read(buffer)
    ) {
      out.write(buffer, 0, len);
    }
  }

  public static String toText(final InputStream in) throws IOException {
    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    writeTo(in, out);
    return new String(out.toByteArray());
  }
}
