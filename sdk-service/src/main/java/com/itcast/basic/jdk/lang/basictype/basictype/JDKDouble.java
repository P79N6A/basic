package com.itcast.basic.jdk.lang.basictype.basictype;

/**
 * Created by treey.qian on 2018/2/2.
 */
public final class JDKDouble extends JDKNumber implements JDKComparable<JDKDouble> {

    public static final double MAX_VALUE = Double.MAX_VALUE;
    public static final double MIN_VALUE = Double.MIN_VALUE;

    private final double value;

    public JDKDouble(double d) {
        this.value = d;
    }

    public String toString() {
        return String.valueOf(value);
    }

    public boolean equals(Object object) {
        if (object instanceof JDKDouble) {
            double d = ((JDKDouble) object).doubleValue();
            return d == value;
        }
        return false;
    }

    @Override
    public int compareTo(JDKDouble object) {
        double d = object.doubleValue();
        return d > value ? -1 : d == value ? 0 : 1;
    }

    public static JDKDouble valueOf(double d) {
        return new JDKDouble(d);
    }

    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }
}
