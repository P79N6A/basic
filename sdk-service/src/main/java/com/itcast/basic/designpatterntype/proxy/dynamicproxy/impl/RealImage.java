package com.itcast.basic.designpatterntype.proxy.dynamicproxy.impl;

import com.itcast.basic.designpatterntype.proxy.dynamicproxy.service.Image;

public class RealImage implements Image {

    @Override
    public void display(String fileName) {
        System.out.println("Displaying " + fileName);
    }

}