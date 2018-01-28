package com.itcast.basic.javabean.introspectiontype;

import java.util.Map;
import java.util.Set;

/**
 * Created by qfl on 16/4/22.
 */
public class InstrospectionUtilsDemo {
    public static void main(String[] args) {
        Person person = new Person(1, "Lily");
        InstrospectionUtils utils = new InstrospectionUtils(person);
        utils.printAllDeclaredMethods();
        Map map = utils.beanToMap();
        Set<Map.Entry<String, Object>> entrys = map.entrySet();
        for (Map.Entry<String, Object> entry : entrys)
            System.out.println(entry.getKey() + "  " + entry.getValue());
    }
}
