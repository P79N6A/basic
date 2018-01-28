package com.itcast.basic.designpatterntype.singleontype;

import java.io.Serializable;

/**
 * Created by qfl on 16/6/2.
 */
public class SerializedSingleon implements Serializable {
    private static SerializedSingleon serializedSingleon = new SerializedSingleon();

    private SerializedSingleon() {

    }

    private Object readResolve() {
        return serializedSingleon;
    }

    public void connect() {

    }

    public void operate() {

    }

}
