package com.itcast.basic.maptype.basicinterface;

import java.util.Map;

/**
 * Created by qfl on 16/4/30.
 */
public interface BasicMap<K, V> extends Map<K, V> {

    interface Entry<K, V> {

        V getValue();

        K getKey();

        V setValue(V value);

        boolean equals(Object o);

        int hashCode();
    }
}
