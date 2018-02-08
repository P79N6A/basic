package com.itcast.basic.jdk.lang.basictype.basictype;

import com.itcast.basic.jdk.io.jdkserializable.JDKSerializable;

/**
 * Created by treey.qian on 2018/2/1.
 */
public abstract class JDKNumber implements JDKSerializable {
    private static final long serialVersionUID = 1l;

    public abstract int intValue();

    public abstract float floatValue();

    public abstract double doubleValue();

    public abstract long longValue();

    public byte byteValue() {
        return (byte) intValue();
    }

    public short shortValue() {
        return (short) intValue();
    }

}
