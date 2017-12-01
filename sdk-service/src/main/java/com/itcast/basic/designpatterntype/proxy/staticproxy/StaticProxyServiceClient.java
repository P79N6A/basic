package com.itcast.basic.designpatterntype.proxy.staticproxy;

import com.itcast.basic.designpatterntype.proxy.staticproxy.impl.RealImage;
import com.itcast.basic.designpatterntype.proxy.staticproxy.service.Image;

/**
 * Created by treey.qian on 2017/11/29.
 */
public class StaticProxyServiceClient {

    public static void main(String[] args) {
        try {
            Image image = new RealImageProxy(new RealImage());
            image.display("01.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
