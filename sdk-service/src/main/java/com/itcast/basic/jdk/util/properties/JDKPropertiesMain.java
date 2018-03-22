package com.itcast.basic.jdk.util.properties;

import org.apache.ibatis.io.Resources;

import java.io.Reader;

/**
 * Created by treey.qian on 2018/3/22.
 */
public class JDKPropertiesMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into JDKPropertiesMain");
            JDKProperties jdkProperties = new JDKProperties();
            Reader reader = Resources.getResourceAsReader("hibernate/hibernate.properties");
            jdkProperties.load(reader);
            System.out.println("jdkProperties=" + jdkProperties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
