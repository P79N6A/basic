package com.itcast.basic.spring.dubbo.notify.service;

/**
 * Created by treey.qian on 2017/11/23.
 */
public interface EventNotify {
    void onreturn(Object result, Object... params);

    void onthrow(Throwable e, Object... params);

}
