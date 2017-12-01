package com.itcast.basic.designpatterntype.status.impl;

import com.itcast.basic.designpatterntype.status.Context;
import com.itcast.basic.designpatterntype.status.service.State;

public class StopState implements State {

    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    public String toString() {
        return "Stop State";
    }
}