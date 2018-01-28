package com.itcast.basic.datatype.doubleapi;

import com.itcast.basic.datatype.basicnumber.BasicNumber;

/**
 * Created by qfl on 16/4/20.
 */
public final class BasicDouble extends BasicNumber implements Comparable<BasicDouble> {
    private double value;
    public static double MAX_VALUE = Double.MAX_VALUE;
    public static double MIN_VALUE = Double.MIN_VALUE;

    public BasicDouble(double d) {
        value = d;
    }

    public boolean equals(Object o) {
        if (o instanceof BasicDouble)
            return doubleToLongBits(((BasicDouble) o).doubleValue()) == doubleToLongBits(value);
        return false;
    }

    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    public double doubleValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    public static BasicDouble valueOf(double d) {
        return new BasicDouble(d);
    }

    public int hashCode() {
        long bits = doubleToLongBits(value);
        return (int) (bits ^ (bits >>> 32));
    }

    /**
     * @param value
     * @return 计算机存储浮点数时的浮点数位
     */
    public static long doubleToLongBits(double value) {
        return Double.doubleToLongBits(value);
    }


    @Override
    public int compareTo(BasicDouble o) {
        return compare(value, o.doubleValue());
    }

    private int compare(double d, double dc) {
        return d < dc ? -1 : (d == dc ? 0 : 1);
    }
}
