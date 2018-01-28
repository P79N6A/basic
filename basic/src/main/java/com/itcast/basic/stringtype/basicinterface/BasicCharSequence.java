package com.itcast.basic.stringtype.basicinterface;

/**
 * Created by qfl on 16/4/20.
 */
public interface BasicCharSequence {

    String toString();

    int length();

    char charAt(int index);

    BasicCharSequence subSequence(int start, int end);
}
