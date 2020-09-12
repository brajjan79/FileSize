package com.github.filesize;

import java.io.File;
import java.io.FileNotFoundException;

public class FileSize {

    private final double bytes;

    /**
     * Constructor for FileSize
     *
     * @param file
     * @throws FileNotFoundException
     */
    public FileSize(final File file) throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException("File " + file.getAbsolutePath() + " does not exist.");
        }
        this.bytes = calculateBytes(file);
    }

    /**
     * Get an instance of FileSize using a static method to do operations without initializing your
     * own instance.
     *
     * @param file
     * @return FileSize
     * @throws FileNotFoundException
     */
    public static FileSize size (final File file) throws FileNotFoundException {
        final FileSize fileSize = new FileSize(file);
        return fileSize;
    }

    /**
     * Get file or content size in bytes
     *
     * @return
     */
    public double getBytes() {
        return bytes;
    }

    /**
     * Get file or content size in kilo bytes
     *
     * @return
     */
    public double getKiloBytes() {
        return getBytes() / 1024;
    }

    /**
     * Get file or content size in mega bytes
     *
     * @return
     */
    public double getMegaBytes() {
        return getKiloBytes() / 1024;
    }

    /**
     * Get file or content size in giga bytes
     *
     * @return
     */
    public double getGigaBytes() {
        return getMegaBytes() / 1024;
    }

    /**
     * Get file or content size in tera bytes
     *
     * @return
     */
    public double getTeraBytes() {
        return getGigaBytes() / 1024;
    }

    /**
     * Get file or content size in bytes
     *
     * @return
     */
    public double getPetaBytes() {
        return getTeraBytes() / 1024;
    }

    /**
     * Get file or content size in Exabytes
     *
     * @return
     */
    public double getExaBytes() {
        return getPetaBytes() / 1024;
    }

    /**
     * Get file or content size in Zettabytes
     *
     * @return
     */
    public double getZettaBytes() {
        return getExaBytes() / 1024;
    }

    /**
     * Get file or content size in Yottabytes
     *
     * @return
     */
    public double getYottaBytes() {
        return getZettaBytes() / 1024;
    }

    private double calculateBytes(final File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        double tmpBytes = 0;
        for (final File subFile: file.listFiles()) {
            tmpBytes = tmpBytes + calculateBytes(subFile);
        }
        return tmpBytes;
    }

}
