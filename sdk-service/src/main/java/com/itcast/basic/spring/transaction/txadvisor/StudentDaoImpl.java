package com.itcast.basic.spring.transaction.txadvisor;

import com.itcast.basic.spring.transaction.BaseDao;
import com.itcast.basic.spring.transaction.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.List;

/**
 * Created by treey.qian on 2017/10/19.
 */
@Service
public class StudentDaoImpl implements BaseDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session initSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List queryForList(String querySql) {
        List<Student> results = initSession().createQuery(querySql, Student.class)
                .setLockMode(LockModeType.PESSIMISTIC_READ)
                .setFirstResult(0)
                .setFetchSize(200)
                .list();
        return results;
    }
}
