package com.github.filesize;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class DataSizeFormatterTest {

    @Test
    public void testInitForFullCoverage() {
        try {
            new DataSizeFormatter();
        } catch (final Exception e) {
            fail("Could not initialize class");
        }
    }

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
    public void testFormatBytesTerrabytes() {
        assertEquals("1.00 TB", DataSizeFormatter.formatBytes(1024L * 1024L * 1024L * 1024L));
    }

    @Test
    public void testFormatBytesPetabytes() {
        assertEquals("1.00 PB", DataSizeFormatter.formatBytes(1024L * 1024L * 1024L * 1024L * 1024L));
    }

    @Test
    public void testFormatBytesWithCustomDecimalPlaces() {
        assertEquals("1.5 MB", DataSizeFormatter.formatBytes(1572864, 1));
    }

    @Test
    public void testFormatBytesLargeNumber() {
        assertEquals("8881.78 PB", DataSizeFormatter.formatBytes(10000000000000000000.0));
    }

}
