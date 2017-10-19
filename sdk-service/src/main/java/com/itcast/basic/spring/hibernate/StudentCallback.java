package com.itcast.basic.spring.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateCallback;

import javax.persistence.LockModeType;
import java.util.List;

/**
 * Created by treey.qian on 2017/10/19.
 */
public class StudentCallback implements HibernateCallback {
    @Override
    public Object doInHibernate(Session session) throws HibernateException {
        Transaction transaction = session.beginTransaction();
        List<Student> results = session.createQuery("from Student", Student.class)
                .setLockMode(LockModeType.PESSIMISTIC_READ)
                .setFirstResult(0)
                .setFetchSize(200)
                .list();
        transaction.commit();
        return results;
    }
}
