package com.itcast.basic.hibernate.namingstrategy;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Created by qfl on 16/7/5.
 * 拦截器
 */
public class DataInteceptor extends EmptyInterceptor {

    @Override
    public void postFlush(Iterator entities) {
        super.postFlush(entities);
    }

    @Override
    public void preFlush(Iterator entities) {
        super.preFlush(entities);
    }

    @Override
    public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof Customer)
            for (int i = 0; i < state.length; i++)
                System.out.println(propertyNames[i].toString() + " ====> " + types[i].getName());
        return false;
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        return false;
    }

    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {

    }
}
