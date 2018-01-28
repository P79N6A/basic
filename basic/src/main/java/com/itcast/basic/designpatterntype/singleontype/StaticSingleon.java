package com.itcast.basic.designpatterntype.singleontype;

/**
 * Created by qfl on 16/6/2.
 * 单例模式的特点:
 * 单例模式的实例必须唯一
 * 单例模式的实例必须由单例类自身创建
 * 单例类必须保证创建的唯一实例可以被其他类访问
 * 本包将演示单例模式(不考虑序列化 仅在安全角度思考)
 */
public class StaticSingleon {
    private static StaticSingleon singleon = new StaticSingleon();

    private StaticSingleon() {

    }

    public static StaticSingleon getSingleon() {
        return singleon;
    }

    public void connect() {

    }

    public void operate() {

    }
}
