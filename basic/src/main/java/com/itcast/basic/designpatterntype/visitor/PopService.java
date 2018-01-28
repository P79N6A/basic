package com.itcast.basic.designpatterntype.visitor;

/**
 * Created by qfl on 16/6/3.
 */
public class PopService implements Service {

    @Override
    public void accept(Visitor visitor) {
        visitor.compress(this);
    }
}
