package com.itcast.basic.designpatterntype.status;

import com.itcast.basic.designpatterntype.status.service.State;

public class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}