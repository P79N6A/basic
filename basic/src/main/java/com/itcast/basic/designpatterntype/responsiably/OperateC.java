package com.itcast.basic.designpatterntype.responsiably;

/**
 * Created by qfl on 16/6/3.
 */
public class OperateC implements Operate {
    private Operate operate;

    public OperateC(Operate operate) {
        this.operate = operate;
    }

    @Override
    public void operate() {
        System.out.println("b处理请求中");
        if (operate != null)
            operate.operate();
    }
}
