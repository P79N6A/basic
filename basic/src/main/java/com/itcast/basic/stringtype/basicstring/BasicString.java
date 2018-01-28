package com.itcast.basic.stringtype.basicstring;

import com.itcast.basic.datatype.basicinterface.BasicCompare;
import com.itcast.basic.datatype.basicinterface.BasicSerivalizable;
import com.itcast.basic.stringtype.basicinterface.BasicCharSequence;

import java.util.Arrays;

/**
 * Created by qfl on 16/4/20.
 */
public final class BasicString implements BasicCharSequence, BasicSerivalizable, BasicCompare<BasicString> {

    private final char[] value;
    private int hash;

    public BasicString() {
        value = new char[0];
    }

    public BasicString(char[] chars) {
        value = Arrays.copyOf(chars, chars.length);
    }

    public BasicString(BasicString orimal) {
        this.value = orimal.value;
        this.hash = orimal.hash;
    }

    public BasicString(char[] chars, int beginIndex, int count) {
        if (beginIndex < 0 || count < 0 || chars.length <= (beginIndex + count))
            throw new StringIndexOutOfBoundsException("数组越界");
        value = Arrays.copyOfRange(chars, beginIndex, count + beginIndex);
    }

    public char[] getCharValue() {
        return Arrays.copyOf(value, value.length);
    }

    @Override
    public int length() {
        return value.length;
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index >= length())
            throw new StringIndexOutOfBoundsException("数组越界");
        return value[index];
    }

    public int indexOf(char c) {
        int i = -1;
        while (i++ < length() - 1) {
            if (value[i] == c)
                return i;
        }
        return -1;
    }

    public int lastIndexOf(char c) {
        int i = length();
        while (i-- > 0) {
            if (value[i] == c)
                return i;
        }
        return -1;
    }

    @Override
    public BasicCharSequence subSequence(int start, int end) {
        return this.subString(start, end);
    }

    public BasicString subString(int start) {
        if (start < 0)
            throw new StringIndexOutOfBoundsException("字符数组越界");
        int count = value.length - start;
        if (count < 0)
            throw new StringIndexOutOfBoundsException("字符数组越界");

        return start == 0 ? this : new BasicString(value, start, count);
    }

    public BasicString subString(int start, int end) {
        if (start < 0)
            throw new StringIndexOutOfBoundsException("数组越界");
        if (end > length())
            throw new StringIndexOutOfBoundsException("数组越界");
        int count = end - start;
        if (count < 0)
            throw new StringIndexOutOfBoundsException("数组越界");
        return start == 0 && end == length() ? this : new BasicString(value, start, count);
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o instanceof BasicString) {
            char[] c1 = value;
            char[] c2 = ((BasicString) o).getCharValue();
            int length1 = c1.length;
            int length2 = c2.length;
            if (length1 == length2) {
                int i = -1;
                while (i++ < length1 - 1) {
                    if (c1[i] != c2[i])
                        return false;
                }
            }
        }
        return false;
    }

    public BasicString toBasicString() {
        return this;
    }

    @Override
    public int compareTo(BasicString o) {
        return compare(value, o.getCharValue());
    }

    private int compare(char[] c1, char[] c2) {
        int length1 = c1.length;
        int length2 = c2.length;
        int min = Math.min(length1, length2);
        int i = -1;
        while (i++ < min - 1) {
            if (c1[i] != c2[i])
                return c1[i] - c2[i];
        }
        return length1 - length2;
    }

    public void getCharArray(int beginIndex, int endIndex, char[] dst, int dstBeginIndex) {
        if (beginIndex < 0 || endIndex > length())
            throw new StringIndexOutOfBoundsException("数组越界");
        if (endIndex < beginIndex)
            throw new StringIndexOutOfBoundsException("数组越界");
        System.arraycopy(value, beginIndex, dst, dstBeginIndex, endIndex - beginIndex);
    }

    public int hashCode() {
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        return h;
    }
}
