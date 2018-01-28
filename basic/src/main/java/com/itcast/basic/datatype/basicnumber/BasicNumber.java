package com.itcast.basic.datatype.basicnumber;

import com.itcast.basic.datatype.basicinterface.BasicSerivalizable;

/**
 * Created by qfl on 16/4/20.
 */
public abstract class BasicNumber implements BasicSerivalizable {
    public abstract int intValue();

    public abstract long longValue();

    public abstract double doubleValue();

    public abstract float floatValue();

    public short shortValue() {
        return (byte) intValue();
    }

    public byte byteValue() {
        return (byte) intValue();
    }

}
