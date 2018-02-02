package com.itcast.basic.jdk.lang.abstractstringbuilder.abstractstringbuilder;

import com.itcast.basic.jdk.io.io.JDKSerializable;

/**
 * Created by treey.qian on 2018/2/2.
 */
public abstract class JDKAbstractStringBuilder implements JDKAppendable, JDKCharSequence, JDKSerializable {


    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public JDKAppendable append(char c) {
        return null;
    }
}
