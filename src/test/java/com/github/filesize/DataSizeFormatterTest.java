package com.github.filesize;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DataSizeFormatterTest {

    @Test
    public void testFormatBytesBytes() {
        assertEquals("512.00 b", DataSizeFormatter.formatBytes(512));
    }

    @Test
    public void testFormatBytesKilobytes() {
        assertEquals("1.00 KB", DataSizeFormatter.formatBytes(1024));
    }

    @Test
    public void testFormatBytesMegabytes() {
        assertEquals("1.00 MB", DataSizeFormatter.formatBytes(1024 * 1024));
    }

    @Test
    public void testFormatBytesGigabytes() {
        assertEquals("1.00 GB", DataSizeFormatter.formatBytes(1024L * 1024L * 1024L));
    }

    @Test
    public void testFormatBytesWithCustomDecimalPlaces() {
        assertEquals("1.5 MB", DataSizeFormatter.formatBytes(1572864, 1)); // 1.5 MB with 1 decimal place
    }

    @Test
    public void testFormatBytesLargeNumber() {
        assertEquals("931.32 GB", DataSizeFormatter.formatBytes(1000000000000L)); // 1 TB in bytes
    }
}
