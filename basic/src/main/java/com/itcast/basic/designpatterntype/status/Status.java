package com.itcast.basic.designpatterntype.status;

/**
 * Created by qfl on 16/6/3.
 */
public class Status {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Status(String status) {
        this.status = status;
    }

    public Object operate(int a, int b) {
        Object o = null;
        switch (status) {
            case "add":
                addOperate(a, b);
                break;
            case "reduce":
                reduceOperate(a, b);
                break;
        }
        return o;
    }

    private Object addOperate(int a, int b) {
        return a + b;
    }

    private Object reduceOperate(int a, int b) {
        return a - b;
    }
}
