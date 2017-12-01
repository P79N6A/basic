package com.itcast.basic.designpatterntype.proxy.dynamicproxy;

import com.itcast.basic.designpatterntype.proxy.dynamicproxy.impl.RealImage;
import com.itcast.basic.designpatterntype.proxy.dynamicproxy.service.Image;

/**
 * Created by treey.qian on 2017/11/29.
 */
public class DynamicServiceClient {
    public static void main(String[] args) {
        try {
            RealImage realImage = new RealImage();
            RealImageDynamicProxy realImageDynamicProxy = new RealImageDynamicProxy(realImage);
            Image image = (Image) realImageDynamicProxy.newInstance();
            image.display("01.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
