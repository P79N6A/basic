package com.itcast.basic.spring.config.transcation;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by qfl on 16/7/31.
 */
public class UserDao implements GeneratorDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List query(String sql) {
        return sessionFactory.openSession().createSQLQuery(sql).list();
    }
}
