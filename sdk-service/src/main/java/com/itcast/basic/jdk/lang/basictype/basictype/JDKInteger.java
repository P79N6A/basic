package com.itcast.basic.jdk.lang.basictype.basictype;

/**
 * Created by Administrator on 2018/2/1.
 */
public final class JDKInteger extends JDKNumber implements JDKComparable<JDKInteger> {

    private final int value;

    public static final int MAX_VALUE = Integer.MAX_VALUE;
    public static final int MIN_VALUE = Integer.MIN_VALUE;

    public JDKInteger(int i) {
        this.value = i;
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public long longValue() {
        return value;
    }

    public boolean equals(Object object) {
        if (object instanceof JDKInteger) {
            int i = ((JDKInteger) object).intValue();
            return i == value;
        }
        return false;
    }

    public int hashCode() {
        return value;
    }

    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int compareTo(JDKInteger object) {
        int i = object.intValue();
        return i > value ? -1 : (i == value) ? 0 : 1;
    }

    public static JDKInteger valueOf(int i) {
        if (JDKIntegerCache.low <= i && i <= JDKIntegerCache.high) {
            return JDKIntegerCache.cache[i - JDKIntegerCache.low];
        }
        return new JDKInteger(i);
    }


    static class JDKIntegerCache {
        private static final int low = -128;
        private static final int high;
        private static final JDKInteger[] cache;

        static {
            int h = 127;
            String integerCacheHighPropValue =
                    sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
            if (integerCacheHighPropValue != null) {
                int i = Integer.parseInt(integerCacheHighPropValue);
                i = Math.min(h, i);
                h = Math.min(i, Integer.MAX_VALUE - (-low) - 1);
            }
            high = h;
            int k = low;
            cache = new JDKInteger[high - low + 1];
            int length = cache.length;
            for (int i = 0; i < length; i++) {
                cache[0] = new JDKInteger(k++);
            }
        }

        private JDKIntegerCache() {

        }
    }

}
