package com.itcast.basic.datatype.integerapi;

import com.itcast.basic.datatype.basicnumber.BasicNumber;

/**
 * Created by qfl on 16/4/19.
 */
public final class BasicInteger extends BasicNumber implements Comparable<BasicInteger> {
    private int value;
    public static final int MAX_VALUE = Integer.MAX_VALUE;
    public static final int MIN_VALUE = Integer.MIN_VALUE;

    public BasicInteger(int v) {
        value = v;
    }

    public int hashCode() {
        return value;
    }

    public boolean equals(Object o) {
        if (o instanceof BasicInteger)
            return this.value == ((BasicInteger) o).intValue();
        return false;
    }

    public static int parseInt(String value) {
        return Integer.parseInt(value);
    }

    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return (long) intValue();
    }

    @Override
    public double doubleValue() {
        return (double) intValue();
    }

    @Override
    public float floatValue() {
        return (float) intValue();
    }

    public static BasicInteger valueOf(int i) {
        if (BasicIntegerCache.low <= i && i <= BasicIntegerCache.hight)
            return BasicIntegerCache.cache[i - BasicIntegerCache.low];
        return new BasicInteger(i);
    }

    public String toString() {
        return toString(value);
    }

    public static String toString(int value) {
        return Integer.toString(value);
    }


    public int compareTo(BasicInteger o) {
        return comapre(value, o.intValue());
    }

    private int comapre(int i, int ic) {
        return i < ic ? -1 : (i == ic ? 0 : 1);
    }

      class BasicIntegerCache {
//        private static final BasicInteger[] cache;
//        private static final int low = -128;
//        private static final int hight;

          {
//            int h = 127;
//            String integerCacheHighPropValue =
//                    sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
//            if (integerCacheHighPropValue != null) {
//                int i = Integer.parseInt(integerCacheHighPropValue);
//                i = Math.min(h, i);
//                h = Math.min(i, Integer.MAX_VALUE - (-low) - 1);
//            }
//            hight = h;
//            int k = low;
//            cache = new BasicInteger[hight - low + 1];
//            for (int j = 0; j < cache.length; j++)
//                cache[j] = new BasicInteger(k++);

        }

        private BasicIntegerCache() {
        }
    }
}
