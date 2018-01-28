package com.itcast.basic.stringtype.basicabstract;

import com.itcast.basic.datatype.basicinterface.BasicSerivalizable;
import com.itcast.basic.stringtype.basicinterface.BasicAppendable;
import com.itcast.basic.stringtype.basicinterface.BasicCharSequence;
import com.itcast.basic.stringtype.basicstring.BasicString;

import java.util.Arrays;

/**
 * Created by qfl on 16/4/20.
 */
public abstract class BasicAbstractStringBuilder implements BasicCharSequence, BasicAppendable, BasicSerivalizable {
    protected char[] value;
    protected int count;

    protected int capacity() {
        return value.length;
    }

    protected BasicAbstractStringBuilder() {
    }

    protected BasicAbstractStringBuilder(int capacity) {
        value = new char[capacity];
    }


    public BasicAbstractStringBuilder append(BasicString s) {
        int len = s.length();
        ensureSize(count + len);
        s.getCharArray(0, len, value, count);
        count += len;
        return this;
    }

    protected BasicString toBasicString() {
        return new BasicString(value);
    }

    private void ensureSize(int minCapacity) {
        if (minCapacity > capacity())
            expandSize(minCapacity);
    }

    private void expandSize(int minCapacity) {
        int newCapacity = 2 * capacity() + 2;
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        value = Arrays.copyOf(value, newCapacity);
    }

    public char charAt(int index) {
        if (index < 0 || index > capacity())
            throw new StringIndexOutOfBoundsException("数组越界");
        return value[index];
    }

    public void trimToSize() {
        if (count < capacity())
            value = Arrays.copyOf(value, count);
    }
}
