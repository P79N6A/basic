package com.itcast.basic.designpatterntype.responsiably;

/**
 * Created by qfl on 16/6/3.
 */
public class OperateA implements Operate {
    private Operate operate;

    public OperateA(Operate operate) {
        this.operate = operate;
    }

    @Override
    public void operate() {
        System.out.println("a处理请求中");
        if (operate != null)
            operate.operate();
    }
}
