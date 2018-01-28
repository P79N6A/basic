package com.itcast.basic.jpa.service.user;

import com.itcast.basic.jpa.domain.User;
import com.itcast.basic.jpa.framework.Utils.EntityUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by qfl on 16/6/10.
 */
public class UserServiceImpl implements UserService {
    private EntityManager manager = EntityUtils.getEntityManager(EntityUtils.DBNAME);

    @Override
    public void saveUser(User user) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(user);
        transaction.commit();
    }

    @Override
    public User findUserById(int id) {
        return manager.find(User.class, id);
    }

    @Override
    public void deleteUser(User user) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.remove(user);
        transaction.commit();
    }

    @Override
    public User findUserByName(String name) {
        return (User) manager.createNamedQuery("queryByName").setParameter("name", name).getSingleResult();
    }

    @Override
    public List findUsersByCondition(String sql) {
        return manager.createQuery(sql).getResultList();
    }

}
