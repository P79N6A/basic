package com.itcast.basic.designpatterntype.singleontype;

/**
 * Created by qfl on 16/6/2.
 */
public class StaticBlockSingleon {
    private static StaticBlockSingleon staticBlockSingleon;

    static {
        staticBlockSingleon = new StaticBlockSingleon();
    }

    private StaticBlockSingleon() {
    }

    public StaticBlockSingleon getStaticBlockSingleon() {
        return staticBlockSingleon;
    }

    public void connect() {

    }

    public void operate() {

    }

}
