package com.github.filesize;

import java.io.File;
import java.io.FileNotFoundException;

public class FileSize {

    private final double bytes;

    public FileSize(final File file) throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException("File " + file.getAbsolutePath() + " does not exist.");
        }
        this.bytes = calculateBytes(file);
    }

    public double getBytes() {
        return bytes;
    }

    public double getKiloBytes() {
        return getBytes() / 1024;
    }

    public double getMegaBytes() {
        return getKiloBytes() / 1024;
    }

    public double getGigaBytes() {
        return getMegaBytes() / 1024;
    }

    public double getTeraBytes() {
        return getGigaBytes() / 1024;
    }

    public double getPetaBytes() {
        return getTeraBytes() / 1024;
    }

    public double getExaBytes() {
        return getPetaBytes() / 1024;
    }

    public double getZettaBytes() {
        return getExaBytes() / 1024;
    }

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
