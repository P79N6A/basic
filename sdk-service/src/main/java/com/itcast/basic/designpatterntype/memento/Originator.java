package com.itcast.basic.designpatterntype.memento;

/**
 * Created by treey.qian on 2017/11/30.
 */
public class Originator {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Memento saveStatusToMemento() {
        return new Memento(status);
    }

    public void getStatusFromMemento(Memento memento) {
        status = memento.getStatus();
    }
}
