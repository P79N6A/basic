package com.itcast.basic.jdk.lang.basictype.basictype;

import com.itcast.basic.jdk.io.jdkserializable.JDKSerializable;

/**
 * Created by treey.qian on 2018/2/2.
 */
public final class JDKCharater implements JDKSerializable, JDKComparable<JDKCharater> {

    public static final char MIN_VALUE = '\u0000';
    public static final char MAX_VALUE = '\uFFFF';

    private final char value;

    public JDKCharater(char c) {
        this.value = c;
    }

    public JDKCharater valueOf(char c) {
        if (c < 128) {
            return JDKCharaterCache.cache[c];
        }
        return new JDKCharater(c);
    }

    static class JDKCharaterCache {
        private static final JDKCharater[] cache = new JDKCharater[128];

        static {
            int length = cache.length;
            for (int i = 0; i < length; i++) {
                cache[i] = new JDKCharater((char) i);
            }
        }
    }

    public char charValue() {
        return value;
    }

    @Override
    public int compareTo(JDKCharater object) {
        char c = object.charValue();
        return value - c;
    }

    public boolean equals(Object object) {
        if (object instanceof JDKCharater) {
            char c = ((JDKCharater) object).charValue();
            return c == value;
        }
        return false;
    }

    public String toString() {
        return String.valueOf(value);
    }

    public static boolean isLowerCase(char c) {
        return Character.isLowerCase(c);
    }

    public static boolean isSuperCase(char c) {
        return Character.isUpperCase(c);
    }

    public static char toLowerCase(char c) {
        return Character.toLowerCase(c);
    }

    public static char toSuperCase(char c) {
        return Character.toUpperCase(c);
    }

    public static boolean isLetter(char c) {
        return Character.isLetter(c);
    }
}
