package io.github.tau34.ecg.util;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.math.BigInteger;
import java.util.Arrays;

public class LargeInteger {
    private final SmallInteger[] si;
    private static final BigInteger MIN = BigInteger.ZERO;
    public static final LargeInteger MIN_VALUE = new LargeInteger(MIN);
    private static final BigInteger MAX = new BigInteger("9").pow(128);
    public static final LargeInteger MAX_VALUE = new LargeInteger(MAX.subtract(BigInteger.ONE));

    public LargeInteger(BigInteger i) {
        if (i.compareTo(MIN) < 0) {
            si = MIN_VALUE.si;
        } else if (i.compareTo(MAX) >= 0) {
            si = MAX_VALUE.si;
        } else {
            si = toBase9(i);
        }
    }

    public LargeInteger add(LargeInteger a) {
        int carry = 0;

        for (int i = 0; i < 128; i++) {
            int sum = si[i].toByte() + a.si[i].toByte() + carry;
            si[i] = new SmallInteger(sum % 9);
            carry = sum / 9;
        }

        return this;
    }

    public static SmallInteger[] toBase9(BigInteger num) {
        SmallInteger[] digits = new SmallInteger[128];
        int index = 0;

        while (num.compareTo(BigInteger.ZERO) > 0) {
            byte dValue = num.mod(BigInteger.valueOf(9)).byteValue();
            digits[index++] = new SmallInteger(dValue);
            num = num.divide(BigInteger.valueOf(9));
        }

        return Arrays.copyOf(digits, index == 0 ? 1 : index);
    }

    public static LargeInteger fromStackList(NonNullList<ItemStack> sl) {
        LargeInteger res = new LargeInteger(MIN);

        for (int i = 0; i < 128; i++) {
            res.si[i] = new SmallInteger(sl.get(i).getCount());
        }

        return res;
    }

    public NonNullList<ItemStack> toStackList() {
        NonNullList<ItemStack> items = NonNullList.withSize(128, ItemStack.EMPTY);

        for (int i = 0; i < 128; i++) {
            items.set(i, new ItemStack(Items.COBBLESTONE, this.si[i].toByte()));
        }

        return items;
    }
}
