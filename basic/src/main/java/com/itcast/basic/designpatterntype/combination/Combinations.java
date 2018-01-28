package com.itcast.basic.designpatterntype.combination;

import java.util.Vector;

/**
 * Created by qfl on 16/6/3.
 */
public class Combinations implements Combination {
    private Vector vectors = new Vector();

    @Override
    public void add(Combination combination) {
        vectors.add(combination);
    }

    @Override
    public void remove(Combination combination) {
        vectors.remove(combination);
    }

    @Override
    public void operate() {
        System.out.println("进行树枝节点操作");
    }
}
