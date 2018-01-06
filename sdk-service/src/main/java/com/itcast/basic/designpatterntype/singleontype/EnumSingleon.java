package com.itcast.basic.designpatterntype.singleontype;

/**
 * Created by treey.qian on 2017/11/28.
 * 枚举方式实现单例
 */
public enum EnumSingleon {
    SINGLEON;

    private int i = 100;

    public int incr() {
        i++;
        return i;
    }
}
