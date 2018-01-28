package com.itcast.basic.javabean.beantpropertylisten;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

/**
 * Created by qfl on 16/5/10.
 * 监听javaBean属性变化 进行相应处理逻辑
 */
public class BeanPropertyListener implements PropertyChangeListener, VetoableChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        String propertyName = e.getPropertyName();
        System.out.println("java bean 的" + propertyName + "属性值被修改");
        System.out.println("状态变化:" + e.getOldValue() + "->" + e.getNewValue());
    }

    @Override
    public void vetoableChange(PropertyChangeEvent e) throws PropertyVetoException {
        //如果设置的值为某个特殊值（这里为 invalidValue ），拒绝修改
        if (e.getNewValue().equals("invalidValue")) {
            System.out.println("\"" + e.getNewValue()
                    + "\" is try to replace the old value \"" + e.getOldValue() + "\"");
            //抛出异常表示拒绝修改属性
            throw new PropertyVetoException(
                    "What you set \"invalidValue\" is a invalid value! operate fail!",
                    e);
        }
    }
}
