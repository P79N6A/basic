package com.itcast.basic.designpatterntype.combination;

/**
 * Created by qfl on 16/6/3.
 */
public interface Combination {
    void add(Combination combination);
    void remove(Combination combination);
    void operate();
}
