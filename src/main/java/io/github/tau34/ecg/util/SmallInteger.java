package io.github.tau34.ecg.util;

public class SmallInteger {
    private final byte value;

    public SmallInteger(int val) {
        if (val < 0) {
            value = 0;
        } else if (val > 8) {
            value = 8;
        } else {
            value = (byte) val;
        }
    }

    public byte toByte() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
