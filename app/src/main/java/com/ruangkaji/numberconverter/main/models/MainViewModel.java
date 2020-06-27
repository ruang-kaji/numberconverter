package com.ruangkaji.numberconverter.main.models;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ruangkaji.numberconverter.utils.MathConvert;
import com.ruangkaji.numberconverter.utils.NumFomatter;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> decimalNum;
    private MutableLiveData<String> binaryNum;
    private MutableLiveData<String> octalNum;
    private MutableLiveData<String> hexadecimalNum;

    public LiveData<String> getDec() {
        if (decimalNum == null) {
            decimalNum = new MutableLiveData<>();
            decimalNum.postValue("0");
        }
        return decimalNum;
    }

    public LiveData<String> getBin() {
        if (binaryNum == null) {
            binaryNum = new MutableLiveData<>();
            binaryNum.postValue("0");
        }
        return binaryNum;
    }

    public LiveData<String> getOct() {
        if (octalNum == null) {
            octalNum = new MutableLiveData<>();
            octalNum.postValue("0");
        }
        return octalNum;
    }

    public LiveData<String> getHex() {
        if (hexadecimalNum == null) {
            hexadecimalNum = new MutableLiveData<>();
            hexadecimalNum.postValue("0");
        }
        return hexadecimalNum;
    }

    public void clear() {
        decimalNum.postValue("0");
        binaryNum.postValue("0");
        octalNum.postValue("0");
        hexadecimalNum.postValue("0");
    }

    public void addDec(String dec) {
        String newVal = addVal(decimalNum.getValue(), dec);
        if (newVal != null && !newVal.equals(decimalNum.getValue())) {
            decimalNum.postValue(newVal);
            binaryNum.postValue(NumFomatter.formatBin(MathConvert.dec2bin(newVal)));
            octalNum.postValue(NumFomatter.formatOct(MathConvert.dec2oct(newVal)));
            hexadecimalNum.postValue(NumFomatter.formatHex(MathConvert.dec2hex(newVal)));
        }
    }

    public void delDec() {
        String newVal = delVal(decimalNum.getValue());
        if (newVal != null && !newVal.equals(decimalNum.getValue())) {
            decimalNum.postValue(newVal);
            binaryNum.postValue(NumFomatter.formatBin(MathConvert.dec2bin(newVal)));
            octalNum.postValue(NumFomatter.formatOct(MathConvert.dec2oct(newVal)));
            hexadecimalNum.postValue(NumFomatter.formatHex(MathConvert.dec2hex(newVal)));
        }
    }

    public void addBin(String bin) {
        String newVal = addVal(cleanVal(binaryNum.getValue()), bin);
        if (newVal != null && !newVal.equals(decimalNum.getValue())) {
            binaryNum.postValue(NumFomatter.formatBin(newVal));
            String dec = MathConvert.bin2dec(newVal);
            decimalNum.postValue(dec);
            octalNum.postValue(NumFomatter.formatOct(MathConvert.dec2oct(dec)));
            hexadecimalNum.postValue(NumFomatter.formatHex(MathConvert.dec2hex(dec)));
        }
    }

    public void delBin() {
        String newVal = delVal(cleanVal(binaryNum.getValue()));
        if (newVal != null && !newVal.equals(binaryNum.getValue())) {
            binaryNum.postValue(NumFomatter.formatBin(newVal));
            String dec = MathConvert.bin2dec(newVal);
            decimalNum.postValue(dec);
            octalNum.postValue(NumFomatter.formatOct(MathConvert.dec2oct(dec)));
            hexadecimalNum.postValue(NumFomatter.formatHex(MathConvert.dec2hex(dec)));
        }
    }

    public void addOct(String oct) {
        String newVal = addVal(cleanVal(octalNum.getValue()), oct);
        if (newVal != null && !newVal.equals(octalNum.getValue())) {
            octalNum.postValue(NumFomatter.formatOct(newVal));
            String dec = MathConvert.oct2dec(newVal);
            decimalNum.postValue(dec);
            binaryNum.postValue(NumFomatter.formatBin(MathConvert.dec2bin(dec)));
            hexadecimalNum.postValue(NumFomatter.formatHex(MathConvert.dec2hex(dec)));
        }
    }

    public void delOct() {
        String newVal = delVal(cleanVal(octalNum.getValue()));
        if (newVal != null && !newVal.equals(octalNum.getValue())) {
            octalNum.postValue(NumFomatter.formatOct(newVal));
            String dec = MathConvert.oct2dec(newVal);
            decimalNum.postValue(dec);
            binaryNum.postValue(NumFomatter.formatBin(MathConvert.dec2bin(dec)));
            hexadecimalNum.postValue(NumFomatter.formatHex(MathConvert.dec2hex(dec)));
        }
    }

    public void addHex(String hex) {
        String newVal = addVal(cleanVal(hexadecimalNum.getValue()), hex);
        if (newVal != null && !newVal.equals(hexadecimalNum.getValue())) {
            hexadecimalNum.postValue(NumFomatter.formatHex(newVal));
            String dec = MathConvert.hex2dec(newVal);
            decimalNum.postValue(dec);
            binaryNum.postValue(NumFomatter.formatBin(MathConvert.dec2bin(dec)));
            octalNum.postValue(NumFomatter.formatOct(MathConvert.dec2oct(dec)));
        }
    }

    public void delHex() {
        String newVal = delVal(cleanVal(hexadecimalNum.getValue()));
        if (newVal != null && !newVal.equals(hexadecimalNum.getValue())) {
            hexadecimalNum.postValue(NumFomatter.formatHex(newVal));
            String dec = MathConvert.hex2dec(newVal);
            decimalNum.postValue(dec);
            binaryNum.postValue(NumFomatter.formatBin(MathConvert.dec2bin(dec)));
            octalNum.postValue(NumFomatter.formatOct(MathConvert.dec2oct(dec)));
        }
    }

    private static String cleanVal(@Nullable String val) {
        if (val != null)
            return val.replaceAll("[^0-9A-F]+", "");
        return "0";
    }

    private static String addVal(String oldVal, String newVal) {
        if (oldVal != null)
            if (!oldVal.equals("0"))
                oldVal = oldVal + newVal;
            else
                oldVal = newVal;
        return oldVal;
    }

    private static String delVal(String oldVal) {
        if (oldVal != null)
            if (oldVal.length() > 1)
                oldVal = oldVal.substring(0, oldVal.length() - 1);
            else if (!oldVal.equals("0"))
                oldVal = "0";
        return oldVal;
    }
}
