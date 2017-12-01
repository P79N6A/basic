package com.itcast.basic.designpatterntype.iterator.impl;

import com.itcast.basic.designpatterntype.iterator.service.Container;
import com.itcast.basic.designpatterntype.iterator.service.Iterator;

public class NameRepository implements Container {

    public NameRepository(String[] names) {
        this.names = names;
    }

    private String[] names;

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}