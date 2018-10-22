package com.github.augustomoura.cnes.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public abstract class ZipFileFilterInputStream extends FilterInputStream {

  private final ZipInputStream in;

  protected ZipFileFilterInputStream(final ZipInputStream in) throws IOException {
    super(in);
    this.in = in;
    iterateUntilMatchingEntry();
  }

  abstract protected boolean zipEntryMatches(final ZipEntry entry);

  private void iterateUntilMatchingEntry() throws IOException {
    for (
        ZipEntry entry = in.getNextEntry();
        entry != null;
        entry = in.getNextEntry()
    ) {
      if (zipEntryMatches(entry)) {
        break;
      }
    }
  }

}
