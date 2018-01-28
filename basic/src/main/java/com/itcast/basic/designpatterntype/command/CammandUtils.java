package com.itcast.basic.designpatterntype.command;

/**
 * Created by qfl on 16/6/3.
 */
public class CammandUtils {
    private Cammand cammand;

    public Cammand getCammand() {
        return cammand;
    }

    public void setCammand(Cammand cammand) {
        this.cammand = cammand;
    }

    public void operate() {
        this.cammand.operate();
    }
}
