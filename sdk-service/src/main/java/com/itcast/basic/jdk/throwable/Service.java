package com.itcast.basic.jdk.throwable;

import java.io.IOException;

/**
 * Created by treey.qian on 2018/1/30.
 */
public interface Service {
    void sys() throws IOException;

//    void sys0() throws RuntimeException;

    void sys1();

//    void sys2();
}
