package com.itcast.basic.datatype.charapi;

import java.io.Serializable;

/**
 * Created by qfl on 16/4/20.
 */
public final class BasicCharacter implements Serializable, Comparable<BasicCharacter> {

    private char value;

    public BasicCharacter(char c) {
        value = c;
    }

    public char charValue() {
        return value;
    }

    public static BasicCharacter valueOf(char c) {
        if (c <= 127) return BasicCharacterCache.cache[(int) c];
        return new BasicCharacter(c);
    }

    public boolean equals(Object o) {
        if (o instanceof BasicCharacter)
            return value == ((BasicCharacter) o).value;
        return false;
    }

    static class BasicCharacterCache {
        private static final BasicCharacter[] cache = new BasicCharacter[128];

        static {
            for (int i = 0; i < cache.length; i++)
                cache[i] = new BasicCharacter((char) i);
        }

        private BasicCharacterCache() {
        }
    }

    @Override
    public int compareTo(BasicCharacter o) {
        return compare(value, o.charValue());
    }

    private int compare(char c, char cc) {
        return c - cc;
    }
}
