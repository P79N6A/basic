package com.itcast.basic.jdk.lang.abstractstringbuilder.abstractstringbuilder;

import com.itcast.basic.jdk.io.io.JDKSerializable;

import java.util.Arrays;

/**
 * Created by treey.qian on 2018/2/2.
 */
public abstract class JDKAbstractStringBuilder implements JDKAppendable, JDKCharSequence, JDKSerializable {

    char[] value;
    int count;

    JDKAbstractStringBuilder() {

    }

    public JDKAbstractStringBuilder(int capacity) {
        if (capacity < 0) {
            throw new StringIndexOutOfBoundsException(capacity);
        }
        value = new char[capacity];
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity > capacity()) {
            extendCapacity(newCapacity);
        }
    }


    private void extendCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new StringIndexOutOfBoundsException(minCapacity);
        }
        int capacity = value.length;
        if (minCapacity > capacity) {
            int maxCapacity = capacity * 2 + 2;
            maxCapacity = (maxCapacity > minCapacity ? maxCapacity : minCapacity);
            value = Arrays.copyOf(value, maxCapacity);
        }
    }

    public void trimToSize() {
        if (count < value.length) {
            value = Arrays.copyOf(value, count);
        }
    }


    @Override
    public int length() {
        return count;
    }

    public int capacity() {
        return value.length;
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index > count) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return value[index];
    }


    public void reverse() {
        char[] newChars = {};
        int count = 0;
        int index = capacity() - 1;
        for (; index >= 0; index--) {
            newChars[count++] = value[index];
        }
    }

    @Override
    public JDKAppendable append(char c) {
        int capacity = value.length;
        extendCapacity(capacity + 1);
        value[count++] = c;
        return this;
    }
}
