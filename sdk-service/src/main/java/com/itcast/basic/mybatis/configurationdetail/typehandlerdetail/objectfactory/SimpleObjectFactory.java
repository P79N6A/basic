package com.itcast.basic.mybatis.configurationdetail.typehandlerdetail.objectfactory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Administrator on 2018/1/7.
 */
public class SimpleObjectFactory extends DefaultObjectFactory {

    @Override
    public void setProperties(Properties properties) {
        Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();
        for (Map.Entry entry : entrySet) {
            System.out.println("key is " + entry.getKey() + " value is" + entry.getValue());
        }
        super.setProperties(properties);
    }

    @Override
    public <T> T create(Class<T> type) {
        System.out.println("无参构造方法");
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        System.out.println("有参构造方法");
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        System.out.println("无参构造方法");
        return super.isCollection(type);
    }
}
