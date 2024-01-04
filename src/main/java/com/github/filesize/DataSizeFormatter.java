package com.github.filesize;

import java.util.Locale;

public class DataSizeFormatter {

    private static int defaultMaxWidth = 4;
    private static int defaultMaxDecimals = 2;

    /**
     * Format bytes to a human readable String converted to most fit data size format.
     *
     * Default: 4 max width and 2 decimals
     *
     * Example: 1024 bytes will be "    1 KB" 1048576 bytes will be "  1.0 MB"
     *
     * @param bytes :: size in bytes
     * @return String
     */
    public static String formatBytes(double bytes) {
        return formatBytes(bytes, defaultMaxWidth, defaultMaxDecimals);
    }

    /**
     * Format bytes to a human-readable String converted to the most fit data size format.
     *
     * @param bytes       :: size in bytes
     * @param maxWidth    :: Max string with (excluding space + KB, MB ...)
     * @param maxDecimals :: Maximum number of decimals to use
     * @return String
     */
    public static String formatBytes(double bytes, int maxWidth, int maxDecimals) {
        final String[] units = { "b", "KB", "MB", "GB", "TB", "PB" };
        int unitIndex = 0;
        double transformedBytes = bytes;

        while (transformedBytes >= 1024 && unitIndex < units.length - 1) {
            transformedBytes /= 1024;
            unitIndex++;
        }

        final String numberFormat = unitIndex >= 2 ? "%." + getMaxDecimals(maxWidth, transformedBytes, maxDecimals) + "f" : "%.0f";
        final String formatSpecifier = "%" + (maxWidth + 1) + "s %s";
        final String formattedNumber = String.format(Locale.US, numberFormat, transformedBytes);

        return String.format(Locale.US, formatSpecifier, formattedNumber, units[unitIndex]);
    }

    private static int getMaxDecimals(int maxWidth, double number, int maxDecimals) {
        final int length = String.valueOf((int) Math.abs(number)).length();
        return maxWidth - length > maxDecimals ? maxDecimals : maxWidth - length;
    }

}
