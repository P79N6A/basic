package com.itcast.basic.designpatterntype.abstractfactory.product;

import com.itcast.basic.designpatterntype.abstractfactory.service.Color;

/**
 * Created by treey.qian on 2017/11/27.
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("fill red");
    }
}
