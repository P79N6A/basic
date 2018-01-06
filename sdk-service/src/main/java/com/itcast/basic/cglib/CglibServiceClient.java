package com.itcast.basic.cglib;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by treey.qian on 2017/10/26.
 */
public class CglibServiceClient {
    private static final Log logger = LogFactory.getLog(CglibServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into CglibServiceClient");
            Map propertyMap = new HashMap();
            propertyMap.put("name", "lily");
            propertyMap.put("age", 25);
            propertyMap.put("sex", "man");
            CglibBeanUtil cglibBeanUtil = new CglibBeanUtil(propertyMap);
            Object object = cglibBeanUtil.getObject();
            logger.info("object class is " + object.getClass().getName());
            Method[] methods = object.getClass().getDeclaredMethods();
            for (Method method : methods) {
                logger.info("method name is " + method.getName());
            }
        } catch (Exception e) {
            logger.info("CglibServiceClient error message is {}", e);
        }
    }
}
