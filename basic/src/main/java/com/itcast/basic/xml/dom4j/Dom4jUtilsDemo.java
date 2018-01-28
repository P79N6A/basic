package com.itcast.basic.xml.dom4j;

import java.io.File;

/**
 * Created by qfl on 16/6/9.
 */
public class Dom4jUtilsDemo {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + Dom4jUtils.class.getPackage().getName().replace(".", File.separator) + File.separator + "weather.xml";
        System.out.println(path);
//        Dom4jUtils.readXMLBySax(path);
//        Dom4jUtils.readXMLByVisitor(path);
        Dom4jUtils.writeXML(path);
    }
}
