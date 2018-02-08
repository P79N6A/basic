package com.itcast.basic.jdk.lang.abstractstringbuilder.abstractstringbuilder;

import com.itcast.basic.jdk.io.jdkserializable.JDKSerializable;
import com.itcast.basic.jdk.lang.basictype.basictype.JDKComparable;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/2/2.
 */
public final class JDKString implements JDKSerializable, JDKComparable<JDKString>, JDKCharSequence {

    private final char[] value;

    private int hash;

    public JDKString() {
        value = new char[]{};
    }

    public JDKString(JDKString jdkString) {
        value = jdkString.value;
        hash = jdkString.hash;
    }

    public JDKString(char[] chars) {
        value = Arrays.copyOf(chars, chars.length);
    }


    public JDKString(char[] chars, int offset, int count) {
        if (chars == null) {
            throw new NullPointerException(new String(chars));
        }
        if (offset < 0) {
            throw new StringIndexOutOfBoundsException(offset);
        }

        if (count < 0) {
            throw new StringIndexOutOfBoundsException(count);
        }

        if (count == 0 && offset == 0) {
            value = new char[]{};
            return;
        }

        if (chars.length < offset + count) {
            throw new StringIndexOutOfBoundsException(offset + count);
        }
        value = Arrays.copyOfRange(chars, offset, count);
    }

    @Override
    public int compareTo(JDKString object) {
        int len = object.length();
        int length = value.length;
        if (len == length) {
            int index = 0;
            while (index < length) {
                char c0 = value[index];
                char c1 = object.charAt(index);
                if (c0 > c1) {
                    return 1;
                } else if (c0 < c1) {
                    return -1;
                }
                index++;
            }
            return 0;
        }
        return length > len ? 1 : -1;
    }

    @Override
    public int length() {
        return value.length;
    }

    public JDKString toJDKString() {
        return this;
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index > value.length) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return value[index];
    }

    public char[] toCharArray() {
        return value;
    }

    public JDKString toLowerCase() {
        char[] chars = {};
        for (int i = 0; i < value.length; i++) {
            chars[i] = Character.toLowerCase(value[i]);
        }
        return new JDKString(chars);
    }

    public JDKString toSuperCase() {
        char[] chars = {};
        for (int i = 0; i < value.length; i++) {
            chars[i] = Character.toUpperCase(value[i]);
        }
        return new JDKString(chars);
    }

    public JDKString subJDKString(int begin) {
        if (begin < 0) {
            throw new StringIndexOutOfBoundsException(begin);
        }
        int len = value.length;

        if (len < begin) {
            throw new StringIndexOutOfBoundsException(begin);
        }

        return len == begin ? this : new JDKString(value, begin, len);
    }

    public JDKString subJDKString(int begin, int len) {
        if (begin < 0) {
            throw new StringIndexOutOfBoundsException(begin);
        }

        if (len < 0) {
            throw new StringIndexOutOfBoundsException(len);
        }

        if (value.length < begin + len) {
            throw new StringIndexOutOfBoundsException(begin + len);
        }

        return (begin == 0 && len == value.length) ? this : new JDKString(value, begin, len);
    }

    public int indexOf(char c) {
        int index = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i] == c) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int lastIndexOf(char c) {
        int index = -1;
        for (int i = value.length - 1; i >= 0; i--) {
            if (value[i] == c) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof JDKString) {
            char[] chars = ((JDKString) obj).toCharArray();
            int len = chars.length;
            if (len == length()) {
                int index = 0;
                while (index < len) {
                    if (chars[index] != value[index]) {
                        return false;
                    }
                    index++;
                }
                return true;
            }
        }
        return false;
    }

    public JDKString replace(char och, char nch) {
        if (och != nch) {
            int len = value.length;
            int index = -1;
            while (++index < len) {
                if (och == value[index]) {
                    break;
                }
            }

            if (index < len) {
                char[] chars = {};
                for (int i = 0; i < index; i++) {
                    chars[i] = value[i];
                }
                while (index < len) {
                    char c = value[index];
                    chars[index] = (c == och ? nch : c);
                    index++;
                }
                return new JDKString(chars);
            }
        }
        return this;
    }
}
