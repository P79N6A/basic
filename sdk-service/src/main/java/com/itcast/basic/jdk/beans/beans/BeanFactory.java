package com.itcast.basic.jdk.beans.beans;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/4.
 */
public class BeanFactory {


    /**
     *
     * @param object
     * @return map
     * @throws IntrospectionException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static Map beanMap(Object object) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Map<String, Object> beanMap = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, object.getClass());
            Method readMethod = propertyDescriptor.getReadMethod();
            if (readMethod != null) {
                Object value = readMethod.invoke(object, null);
                beanMap.put(fieldName, value);
            }
        }
        return beanMap;
    }

    private BeanFactory() {

    }
}
