package com.github.filesize;

import java.util.Locale;

public class DataSizeFormatter {

    private static int defaultDecimalPlaces = 2;

    /**
     * Format bytes to a human readable String converted to most fit data size format. Default: 2 decimals
     *
     * Example: 1024 bytes will be "1.00KB" 1048576 bytes will be "1.00MB"
     *
     * @param bytes :: size in bytes
     * @return String
     */
    public static String formatBytes(double bytes) {
        return formatBytes(bytes, defaultDecimalPlaces);
    }

    /**
     * Format bytes to a human readable String converted to most fit data size format.
     *
     * Example: 1024 bytes will be "1.00KB" 1048576 bytes will be "1.00MB"
     *
     * @param bytes         :: size in bytes
     * @param decimalPlaces :: Number of decimals to use
     * @return String
     */
    public static String formatBytes(double bytes, int decimalPlaces) {
        final String[] units = { "b", "KB", "MB", "GB", "TB", "PB" };
        int unitIndex = 0;

        double transformedBytes = bytes;
        while (transformedBytes >= 1024 && unitIndex < units.length - 1) {
            transformedBytes /= 1024;
            unitIndex++;
        }

        final String formatSpecifier = "%." + decimalPlaces + "f %s";
        return String.format(Locale.US, formatSpecifier, transformedBytes, units[unitIndex]);
    }
}
