package com.itcast.basic.cglib;

import net.sf.cglib.beans.BeanGenerator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cglib.beans.BeanMap;

import java.util.Map;
import java.util.Set;

/**
 * Created by treey.qian on 2017/10/26.
 */
public class CglibBeanUtil {
    private final Log logger = LogFactory.getLog(CglibBeanUtil.class);

    private Object object;
    private BeanMap beanMap;

    public CglibBeanUtil() {

    }

    public CglibBeanUtil(Map propertyMap) {
        object = generBean(propertyMap);
        beanMap = BeanMap.create(object);
    }

    public void setValue(String key, Object value) {
        beanMap.put(key, value);
    }

    public Object getValue(String key) {
        return beanMap.get(key);
    }

    public Object getObject() {
        return object;
    }

    private Object generBean(Map propertyMap) {
        BeanGenerator beanGenerator = new BeanGenerator();
        for (Map.Entry entry : (Set<Map.Entry>) propertyMap.entrySet()) {
            beanGenerator.addProperty(entry.getKey().toString(), entry.getValue().getClass());
        }
        return beanGenerator.create();
    }

}
