package com.itcast.basic.designpatterntype.singleontype;

/**
 * Created by treey.qian on 2017/11/28.
 * 静态内部类实现单例 将单例类实例化延迟到静态内部类
 */
public class StaticInnerSingleon {


    private StaticInnerSingleon() {

    }

    private static class StaticInnerSingleonHelper {
        private final static StaticInnerSingleon staticInnerSingleon = new StaticInnerSingleon();
    }

    public static final StaticInnerSingleon newInstance() {
        return StaticInnerSingleonHelper.staticInnerSingleon;
    }

}
