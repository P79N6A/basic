package com.itcast.basic.jdk.util.concurrent.concurrentschudler.exchange;

import java.util.concurrent.Exchanger;

/**
 * Created by treey.qian on 2018/3/29.
 */
public class ExchangerUtil {

    public static Object exchangeData(Exchanger exchanger, Object data) throws InterruptedException {
        return exchanger.exchange(data);
    }
}
