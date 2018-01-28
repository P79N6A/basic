package com.itcast.basic.designpatterntype.command;

/**
 * Created by qfl on 16/6/3.
 */
public class TurnOnCammand implements Cammand {
    @Override
    public void operate() {
        System.out.println("执行开机操作");
    }
}
