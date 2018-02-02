package com.itcast.basic.jdk.lang.basictype.basictype;

import com.itcast.basic.jdk.io.io.JDKSerializable;

/**
 * Created by treey.qian on 2018/2/2.
 */
public final class JDKBoolean implements JDKSerializable, JDKComparable<JDKBoolean> {

    public static final JDKBoolean TRUE = new JDKBoolean(true);

    public static final JDKBoolean FALSE = new JDKBoolean(false);

    private final boolean value;

    public JDKBoolean(boolean b) {
        this.value = b;
    }

    public String toString() {
        return String.valueOf(value);
    }

    public boolean booleanValue() {
        return value;
    }

    public static JDKBoolean valueOf(boolean b) {
        return b ? TRUE : FALSE;
    }

    public boolean equals(Object object) {
        if (object instanceof JDKBoolean) {
            boolean b = ((JDKBoolean) object).booleanValue();
            return b == value;
        }
        return false;
    }

    @Override
    public int compareTo(JDKBoolean object) {
        boolean b = object.booleanValue();
        return b == value ? 0 : b ? 1 : -1;
    }
}
