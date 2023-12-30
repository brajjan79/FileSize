package com.github.filesize;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;
import org.mockito.Mockito;

public class TestFileSize {

    private static final long ONE_TERABYTE_IN_BYTES = 1099511627776L;

    private static final double ONE_TERABYTE = 1.0;
    private static final double ONE_TERABYTE_AS_BYTE = 1099511627776.0;
    private static final double ONE_TERABYTE_AS_KB = 1073741824.0;
    private static final double ONE_TERABYTE_AS_MB = 1048576.0;
    private static final double ONE_TERABYTE_AS_GB = 1024.0;
    private static final double ONE_TERABYTE_AS_PETA = 0.0009765625;
    private static final double ONE_TERABYTE_AS_EXA = 9.5367431640625E-7;
    private static final double ONE_TERABYTE_AS_ZETTA = 9.313225746154785E-10;
    private static final double ONE_TERABYTE_AS_YOTTA = 9.094947017729282E-13;

    @Test
    public void testGetFileSizeFromFile() throws Exception {
        final File file = Mockito.mock(File.class);
        Mockito.when(file.exists()).thenReturn(true);
        Mockito.when(file.isDirectory()).thenReturn(false);
        Mockito.when(file.length()).thenReturn(ONE_TERABYTE_IN_BYTES);

        final FileSize fileSize = new FileSize(file);
        assertEquals(ONE_TERABYTE_AS_BYTE, fileSize.getBytes(), 0);
        assertEquals(ONE_TERABYTE_AS_KB, fileSize.getKiloBytes(), 0);
        assertEquals(ONE_TERABYTE_AS_MB, fileSize.getMegaBytes(), 0);
        assertEquals(ONE_TERABYTE_AS_GB, fileSize.getGigaBytes(), 0);
        assertEquals(ONE_TERABYTE, fileSize.getTeraBytes(), 0);
        assertEquals(ONE_TERABYTE_AS_PETA, fileSize.getPetaBytes(), 0);
        assertEquals(ONE_TERABYTE_AS_EXA, fileSize.getExaBytes(), 0);
        assertEquals(ONE_TERABYTE_AS_ZETTA, fileSize.getZettaBytes(), 0);
        assertEquals(ONE_TERABYTE_AS_YOTTA, fileSize.getYottaBytes(), 0);
    }

    @Test
    public void testGetFileSizeFromFileStatic() throws Exception {
        final File file = Mockito.mock(File.class);
        Mockito.when(file.exists()).thenReturn(true);
        Mockito.when(file.isDirectory()).thenReturn(false);
        Mockito.when(file.length()).thenReturn(ONE_TERABYTE_IN_BYTES);

        assertEquals(ONE_TERABYTE_AS_BYTE, FileSize.size(file).getBytes(), 0);
        assertEquals(ONE_TERABYTE_AS_KB, FileSize.size(file).getKiloBytes(), 0);
        assertEquals(ONE_TERABYTE_AS_MB, FileSize.size(file).getMegaBytes(), 0);
        assertEquals(ONE_TERABYTE_AS_GB, FileSize.size(file).getGigaBytes(), 0);
        assertEquals(ONE_TERABYTE, FileSize.size(file).getTeraBytes(), 0);
        assertEquals(ONE_TERABYTE_AS_PETA, FileSize.size(file).getPetaBytes(), 0);
        assertEquals(ONE_TERABYTE_AS_EXA, FileSize.size(file).getExaBytes(), 0);
        assertEquals(ONE_TERABYTE_AS_ZETTA, FileSize.size(file).getZettaBytes(), 0);
        assertEquals(ONE_TERABYTE_AS_YOTTA, FileSize.size(file).getYottaBytes(), 0);
    }

    @Test
    public void testGetFileSizeFromFileStaticNew() throws Exception {
        final File file = Mockito.mock(File.class);
        Mockito.when(file.exists()).thenReturn(true);
        Mockito.when(file.isDirectory()).thenReturn(false);
        Mockito.when(file.length()).thenReturn(ONE_TERABYTE_IN_BYTES);

        assertEquals(ONE_TERABYTE_AS_BYTE, FileSize.getBytes(file), 0);
        assertEquals(ONE_TERABYTE_AS_KB, FileSize.getKiloBytes(file), 0);
        assertEquals(ONE_TERABYTE_AS_MB, FileSize.getMegaBytes(file), 0);
        assertEquals(ONE_TERABYTE_AS_GB, FileSize.getGigaBytes(file), 0);
        assertEquals(ONE_TERABYTE, FileSize.getTeraBytes(file), 0);
        assertEquals(ONE_TERABYTE_AS_PETA, FileSize.getPetaBytes(file), 0);
        assertEquals(ONE_TERABYTE_AS_EXA, FileSize.getExaBytes(file), 0);
        assertEquals(ONE_TERABYTE_AS_ZETTA, FileSize.getZettaBytes(file), 0);
        assertEquals(ONE_TERABYTE_AS_YOTTA, FileSize.getYottaBytes(file), 0);
    }

    @Test
    public void testGetFileSizeFromDirectory() throws Exception {
        final long bytes = 200000L;
        final long numberOfFiles = 16L;
        final File file = getMockedDirectoryWithSubDirs(bytes);

        final FileSize fileSize = new FileSize(file);
        assertEquals(bytes * numberOfFiles, fileSize.getBytes(), 0);
    }

    /**
     * Creates a mocked directory with a total of 16 files and several sub directories.
     * @param bytes
     * @return
     */
    private File getMockedDirectoryWithSubDirs(final long bytes) {
        final File mainDirectory = Mockito.mock(File.class);
        Mockito.when(mainDirectory.exists()).thenReturn(true);
        Mockito.when(mainDirectory.isDirectory()).thenReturn(true);

        final File subDirWithSubDirs = Mockito.mock(File.class);
        Mockito.when(subDirWithSubDirs.exists()).thenReturn(true);
        Mockito.when(subDirWithSubDirs.isDirectory()).thenReturn(true);

        final File subDirWithFilesOnly = Mockito.mock(File.class);
        Mockito.when(subDirWithFilesOnly.exists()).thenReturn(true);
        Mockito.when(subDirWithFilesOnly.isDirectory()).thenReturn(true);

        final File file = Mockito.mock(File.class);
        Mockito.when(file.exists()).thenReturn(true);
        Mockito.when(file.isDirectory()).thenReturn(false);
        Mockito.when(file.length()).thenReturn(bytes);

        final File[] listWithSubSubDirsAndFiles = {file, subDirWithSubDirs, file, subDirWithFilesOnly};
        final File[] listWithSubDirsAndFiles = {file, subDirWithFilesOnly, file, subDirWithFilesOnly};
        final File[] listWithFiles = {file, file, file, file};

        Mockito.when(subDirWithFilesOnly.listFiles()).thenReturn(listWithFiles);
        Mockito.when(subDirWithSubDirs.listFiles()).thenReturn(listWithSubDirsAndFiles);
        Mockito.when(mainDirectory.listFiles()).thenReturn(listWithSubSubDirsAndFiles);

        return mainDirectory;
    }
}
