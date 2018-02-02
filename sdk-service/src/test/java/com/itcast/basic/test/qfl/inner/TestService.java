package com.itcast.basic.test.qfl.inner;

import org.junit.Test;

/**
 * Created by treey.qian on 2018/2/2.
 */
public class TestService {

    @Test
    public void testService() {
        try {
            OuterClassObject outerClassObject = new OuterClassObject();
            OuterClassObject.Inner inner = outerClassObject.new Inner();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
