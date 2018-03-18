package com.itcast.basic.jdk.util.common;

/**
 * Created by qfl on 2018/3/18.
 */
public enum TimeModel {
    SECOND(0, "second"), MINUTE(1, "minute"), HOUR(2, "hour"), DAY(3, "day"), MONTH(4, "month"), YEAR(5, "year");
    private int index;
    private String name;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    TimeModel(int index, String name) {
        this.index = index;
        this.name = name;
    }
}
