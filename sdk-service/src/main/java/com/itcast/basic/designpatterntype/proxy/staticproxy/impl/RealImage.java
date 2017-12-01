package com.itcast.basic.designpatterntype.proxy.staticproxy.impl;

import com.itcast.basic.designpatterntype.proxy.staticproxy.service.Image;

public class RealImage implements Image {

    @Override
    public void display(String fileName) {
        System.out.println("Displaying " + fileName);
    }

}