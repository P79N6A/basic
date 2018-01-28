package com.itcast.basic.xml.jdom;

import java.io.File;

/**
 * Created by qfl on 16/6/9.
 */
public class JdomUtilsDemo {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + JdomUtils.class.getPackage().getName().replace(".", File.separator) + File.separator + "weather.xml";
        System.out.println(path);
//        JdomUtils.readXML(path);
        JdomUtils.writeXML(path);
    }
}
