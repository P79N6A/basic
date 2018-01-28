package com.itcast.basic.xml.sax;

import java.io.File;

/**
 * Created by qfl on 16/6/9.
 */
public class SaxUtilsDemo {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + SaxUtils.class.getPackage().getName().replace(".", File.separator) + File.separator + "weather.xml";
        System.out.println(path);
        SaxUtils.readXML(path);
    }
}
