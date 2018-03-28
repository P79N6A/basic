package com.itcast.basic.jdk.util.vector;

/**
 * Created by treey.qian on 2018/3/21.
 */
public class JDKStack extends JDKVector {

    public boolean push(Object o) {
        return add(o);
    }

    public Object pop() {
        int index = size - 1;
        Object obj = get(index);
        remove(index);
        return obj;
    }
}
