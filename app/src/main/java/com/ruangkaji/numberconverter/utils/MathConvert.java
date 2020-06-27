package com.ruangkaji.numberconverter.utils;

import java.math.BigInteger;

public class MathConvert {
    private static String[] hexArray = {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F"
    };

    public static String dec2bin(String dec) {
        StringBuilder result = new StringBuilder();
        BigInteger iDec = new BigInteger(dec);
        while (iDec.divide(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(0)) > 0) {
            result.insert(0, iDec.mod(BigInteger.valueOf(2)).toString());
            iDec = iDec.divide(BigInteger.valueOf(2));
        }
        result.insert(0, iDec.mod(BigInteger.valueOf(2)).toString());
        return result.toString();
    }

    public static String dec2oct(String dec) {
        StringBuilder result = new StringBuilder();
        BigInteger iDec = new BigInteger(dec);
        while (iDec.divide(BigInteger.valueOf(8)).compareTo(BigInteger.valueOf(0)) > 0) {
            result.insert(0, iDec.mod(BigInteger.valueOf(8)).toString());
            iDec = iDec.divide(BigInteger.valueOf(8));
        }
        result.insert(0, iDec.mod(BigInteger.valueOf(8)).toString());
        return result.toString();
    }

    public static String dec2hex(String dec) {
        StringBuilder result = new StringBuilder();
        BigInteger iDec = new BigInteger(dec);
        while (iDec.divide(BigInteger.valueOf(16)).compareTo(BigInteger.valueOf(0)) > 0) {
            int hex = Integer.parseInt(iDec.mod(BigInteger.valueOf(16)).toString());
            result.insert(0, hexArray[hex]);
            iDec = iDec.divide(BigInteger.valueOf(16));
        }
        int hex = Integer.parseInt(iDec.mod(BigInteger.valueOf(16)).toString());
        result.insert(0, hexArray[hex]);
        return result.toString();
    }

    public static String bin2dec(String bin) {
        String cleanBin = bin.replaceAll("[^0-1]*", "");
        BigInteger iDec = new BigInteger(cleanBin.substring(cleanBin.length() - 1));
        for (int i = cleanBin.length() - 2; i >= 0; i--) {
            if (cleanBin.charAt(i) == '1')
                iDec = iDec.add(BigInteger.valueOf(2).pow(cleanBin.length() - 1 - i));
        }
        return iDec.toString();
    }

    public static String oct2dec(String oct) {
        String cleanOct = oct.replaceAll("[^0-7]*", "");
        BigInteger iDec;
        if (cleanOct.length() > 1)
            iDec = new BigInteger(cleanOct.substring(cleanOct.length() - 1));
        else
            iDec = new BigInteger(cleanOct);
        for (int i = cleanOct.length() - 2; i >= 0; i--) {
            if (cleanOct.charAt(i) != '0')
                iDec = iDec.add(BigInteger.valueOf(cleanOct.charAt(i) - '0')
                        .multiply(BigInteger.valueOf(8).pow(cleanOct.length() - 1 - i)));
        }
        return iDec.toString();
    }

    public static String hex2dec(String hex) {
        String cleanHex = hex.replaceAll("[^0-9A-F]*", "");
        BigInteger iDec;
        if (cleanHex.length() > 1)
            iDec = BigInteger.valueOf(getIntFromHex(cleanHex.charAt(cleanHex.length() - 1)));
        else
            iDec = BigInteger.valueOf(getIntFromHex(cleanHex.charAt(0)));
        for (int i = cleanHex.length() - 2; i >= 0; i--) {
            if (cleanHex.charAt(i) != '0')
                iDec = iDec.add(BigInteger.valueOf(getIntFromHex(cleanHex.charAt(i)))
                        .multiply(BigInteger.valueOf(16).pow(cleanHex.length() - 1 - i)));
        }
        return iDec.toString();
    }

    private static int getIntFromHex(char hexChar) {
        if (hexChar >= 'A' && hexChar <= 'F')
            return (hexChar - 'A') + 10;
        return hexChar - '0';
    }
}
