package com.itcast.basic.jdk.lang.basictype.basictype;

import com.itcast.basic.jdk.io.io.JDKSerializable;

/**
 * Created by treey.qian on 2018/2/1.
 */
public abstract class JDKNumber implements JDKSerializable {
    private static final long serialVersionUID=1l;

    public abstract int intValue();

}
