package com.itcast.basic.jpa.user;

import com.itcast.basic.jpa.EntityUtils;
import com.itcast.basic.jpa.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by qfl on 16/6/10.
 */
public class UserServiceImpl implements UserService {

    private final EntityManager entityManager = EntityUtils.newEntityManagerInstance();

    @Override
    public void saveUser(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
    }

    @Override
    public User findUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(user);
        transaction.commit();
    }

    @Override
    public User findUserByName(String name) {
        return (User) entityManager.createNamedQuery("queryByName").setParameter("name", name).getSingleResult();
    }

    @Override
    public List findUsersByCondition(String sql) {
        return entityManager.createQuery(sql).getResultList();
    }

    private void closeConnoction() {
        EntityUtils.closeEntityManager(entityManager);
    }
}
