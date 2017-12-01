package com.itcast.basic.designpatterntype.proxy.staticproxy;

import com.itcast.basic.designpatterntype.proxy.staticproxy.service.Image;

/**
 * Created by treey.qian on 2017/11/29.
 */
public class RealImageProxy implements Image {

    private Image image;

    public RealImageProxy(Image image) {
        this.image = image;
    }

    @Override
    public void display(String fileName) {
        System.out.println("初始化系统");
        image.display(fileName);
    }
}
