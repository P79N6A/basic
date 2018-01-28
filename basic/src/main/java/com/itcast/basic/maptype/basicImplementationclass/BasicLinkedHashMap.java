package com.itcast.basic.maptype.basicImplementationclass;

/**
 * Created by qfl on 16/5/1.
 */
public class BasicLinkedHashMap<K, V> extends BasicHashMap<K, V> {

    private Entry<K, V> header;
    private static boolean isLoad;

    public BasicLinkedHashMap(int capacity) {
        super(capacity);
    }

    public BasicLinkedHashMap(int capacity, float loadFactor) {
        super(capacity, loadFactor);
    }

    @Override
    void init() {
        header = new Entry<K, V>(null, null, null, -1);
        header.next = header.prev = header;
    }


    static class Entry<K, V> extends BasicHashMap.Entry<K, V> {
        BasicLinkedHashMap.Entry<K, V> prev, next;

        Entry(K key, V value, BasicHashMap.Entry next, int hash) {
            super(key, value, next, hash);
        }

        void addBefore(Entry<K, V> ext) {
            next = ext;
            prev = ext.prev;
            prev.next = this;
            next.prev = this;
        }

        private void remove() {
            prev.next = next;
            next.prev = prev;
        }

        @Override
        void recordAccess(BasicHashMap<K, V> m) {
            BasicLinkedHashMap lm = (BasicLinkedHashMap) m;
            if (isLoad) {
                remove();
                addBefore(lm.header);
            }
        }
    }
}
