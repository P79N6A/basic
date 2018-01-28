package com.itcast.basic.xml.pull;

import java.io.File;

/**
 * Created by qfl on 16/6/9.
 */
public class PullUtilsDemo {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + PullUtils.class.getPackage().getName().replace(".", File.separator) + File.separator + "weather.xml";
        System.out.println(path);
        PullUtils.readXML(path);
    }
}
