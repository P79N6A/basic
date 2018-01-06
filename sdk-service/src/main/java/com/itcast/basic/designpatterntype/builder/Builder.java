package com.itcast.basic.designpatterntype.builder;

/**
 * Created by treey.qian on 2017/11/28.
 */
public interface Builder {
    void buildHead(String head);

    void buildBody(String body);

    void buildHander(String hander);

    void buildFoot(String foot);

    Object buildObject();
}
