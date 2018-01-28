package com.itcast.basic.xml.xpath;

import java.io.File;

/**
 * Created by qfl on 16/6/9.
 */
public class XpathUtilsDemo {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + XpathUtils.class.getPackage().getName().replace(".", File.separator) + File.separator + "weather.xml";
        System.out.println(path);
        XpathUtils.sysInnerText(path, "//city/@name");
    }
}
