package com.itcast.basic.jdk.beans.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

/**
 * Created by Administrator on 2018/2/4.
 */
public class BeanListener implements PropertyChangeListener, VetoableChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        Object oldvalue = evt.getOldValue();
        Object newValue = evt.getNewValue();
        System.out.println("propertyName=" + propertyName + " oldvalue=" + oldvalue + " newValue=" + newValue);

    }

    @Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
        String name = evt.getPropertyName();
        if ("servialVersionUID".toLowerCase().equals(name.toLowerCase())) {
            throw new PropertyVetoException("servialVersionUID not modify", evt);
        }
    }
}
