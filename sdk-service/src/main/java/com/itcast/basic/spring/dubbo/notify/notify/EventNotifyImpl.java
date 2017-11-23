package com.itcast.basic.spring.dubbo.notify.notify;

import com.itcast.basic.spring.dubbo.notify.service.EventNotify;

import java.util.List;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class EventNotifyImpl implements EventNotify {

    @Override
    public void onreturn(Object result, Object... params) {
        print(params);
        System.out.println("result is " + result);
    }

    @Override
    public void onthrow(Throwable e, Object... params) {
        print(params);
        System.out.println("exception is " + e);
    }

    private void print(Object... params) {
        for (Object param : params) {
            if (param instanceof String) {
                System.out.println("param is " + param.toString());
            } else if (param instanceof List) {
                System.out.println("param size is " + ((List) param).size());
            }
        }
    }
}
