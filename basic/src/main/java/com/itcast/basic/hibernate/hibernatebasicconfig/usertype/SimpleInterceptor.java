package com.itcast.basic.hibernate.hibernatebasicconfig.usertype;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Created by qfl on 16/7/6.
 */
public class SimpleInterceptor extends EmptyInterceptor {
    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
    }

    @Override
    public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println(entity.getClass().getName());
        return false;
    }

    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("删除实体" + entity.getClass().getName());
    }

    @Override
    public void postFlush(Iterator entities) {
        System.out.println("刷新缓存后");
    }

    @Override
    public void preFlush(Iterator entities) {
        System.out.println("刷新缓存前");
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("保存实体" + entity.getClass().getName());
        return false;
    }
}
