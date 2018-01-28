package com.itcast.basic.datatype.booleanapi;

import java.io.Serializable;

/**
 * Created by qfl on 15/1/1.
 */
public final class BasicBoolean implements Serializable, Comparable<BasicBoolean> {
    private boolean value;
    private static final BasicBoolean TRUE = new BasicBoolean(true);
    private static final BasicBoolean FLASE = new BasicBoolean(false);

    public BasicBoolean(boolean b) {
        value = b;
    }

    public boolean booleanValue() {
        return value;
    }

    public static BasicBoolean valueOf(boolean b) {
        return b ? TRUE : FLASE;
    }

    public static BasicBoolean valueOf(String b) {
        return toBoolean(b) ? TRUE : FLASE;
    }

    private static boolean toBoolean(String b) {
        return (b != null) && b.equalsIgnoreCase("true");
    }

    public String toString() {
        return value ? "true" : "flase";
    }

    public int hashCode() {
        return value ? 1231 : 1237;
    }

    public boolean equals(Object o) {
        if (o instanceof BasicBoolean)
            return this.value == ((BasicBoolean) o).booleanValue();
        return false;
    }

    @Override
    public int compareTo(BasicBoolean o) {
        return compare(value, o.booleanValue());
    }

    private int compare(boolean b, boolean bc) {
        return b == bc ? 0 : (b ? 1 : -1);
    }
}
