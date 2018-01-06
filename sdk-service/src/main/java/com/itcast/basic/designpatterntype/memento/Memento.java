package com.itcast.basic.designpatterntype.memento;

/**
 * Created by treey.qian on 2017/11/30.
 */
public class Memento {
    private String status;

    public Memento(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
