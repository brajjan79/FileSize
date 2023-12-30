package com.github.filesize;

import java.io.File;

public class FileSize {

    private File file;

    /**
     * Constructor for FileSize
     *
     * @param file
     */
    public FileSize(final File file) {
        this.file = file;
    }

    /**
     * Get an instance of FileSize using a static method to do operations without initializing your
     * own instance.
     *
     * @param file
     * @return FileSize
     */
    @Deprecated
    public static FileSize size(final File file) {
        final FileSize fileSize = new FileSize(file);
        return fileSize;
    }

    /**
     * Get file or content size in bytes
     *
     * @return
     */
    public double getBytes() {
        return calculateBytes(this.file);
    }

    /**
     * Get file or content size in bytes
     *
     * @return
     */
    public static double getBytes(final File file) {
        return new FileSize(file).getBytes();
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
     * Get file or content size in kilo bytes
     *
     * @return
     */
    public static double getKiloBytes(final File file) {
        return new FileSize(file).getKiloBytes();
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
     * Get file or content size in mega bytes
     *
     * @return
     */
    public static double getMegaBytes(final File file) {
        return new FileSize(file).getMegaBytes();
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
     * Get file or content size in giga bytes
     *
     * @return
     */
    public static double getGigaBytes(final File file) {
        return new FileSize(file).getGigaBytes();
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
     * Get file or content size in tera bytes
     *
     * @return
     */
    public static double getTeraBytes(final File file) {
        return new FileSize(file).getTeraBytes();
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
     * Get file or content size in bytes
     *
     * @return
     */
    public static double getPetaBytes(final File file) {
        return new FileSize(file).getPetaBytes();
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
     * Get file or content size in Exabytes
     *
     * @return
     */
    public static double getExaBytes(final File file) {
        return new FileSize(file).getExaBytes();
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
     * Get file or content size in Zettabytes
     *
     * @return
     */
    public static double getZettaBytes(final File file) {
        return new FileSize(file).getZettaBytes();
    }

    /**
     * Get file or content size in Yottabytes
     *
     * @return
     */
    public double getYottaBytes() {
        return getZettaBytes() / 1024;
    }

    /**
     * Get file or content size in Yottabytes
     *
     * @return
     */
    public static double getYottaBytes(final File file) {
        return new FileSize(file).getYottaBytes();
    }

    private double calculateBytes(final File file) {
        if (!file.exists()) {
            return 0.0;
        }
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
