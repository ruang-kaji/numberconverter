package com.ruangkaji.numberconverter.utils;

public class NumFomatter {
    public static String formatBin(String bin) {
        StringBuilder stringBuilder = new StringBuilder(bin);
        stringBuilder.reverse();
        boolean isSpace = true;
        for (int i = 0; i < stringBuilder.length(); i += 12) {
            if (i > 0) {
                stringBuilder.insert(i, isSpace ? " " : "\n");
                isSpace = !isSpace;
                i++;
            }
        }
        return stringBuilder.reverse().toString();
    }

    public static String formatOct(String oct) {
        StringBuilder stringBuilder = new StringBuilder(oct);
        stringBuilder.reverse();
        boolean isSpace = true;
        for (int i = 0; i < stringBuilder.length(); i += 4) {
            if (i > 0) {
                stringBuilder.insert(i, isSpace ? " " : "\n");
                isSpace = !isSpace;
                i++;
            }
        }
        return stringBuilder.reverse().toString();
    }

    public static String formatHex(String hex) {
        StringBuilder stringBuilder = new StringBuilder(hex);
        stringBuilder.reverse();
        boolean isSpace = true;
        for (int i = 0; i < stringBuilder.length(); i += 3) {
            if (i > 0) {
                stringBuilder.insert(i, isSpace ? " " : "\n");
                isSpace = !isSpace;
                i++;
            }
        }
        return stringBuilder.reverse().toString();
    }
}
