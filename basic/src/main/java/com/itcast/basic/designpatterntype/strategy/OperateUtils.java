package com.itcast.basic.designpatterntype.strategy;

/**
 * Created by qfl on 16/6/3.
 */
public class OperateUtils {
    private Operate operate;

    public OperateUtils(Operate operate) {
        this.operate = operate;
    }

    public Object backResultOperate(int a, int b) {
        return operate.operate(a, b);
    }
}
