package com.itcast.basic.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by qfl on 16/6/10.
 */
public class EntityUtils {
    private static final String jpaEntityManager = "jpaEntityManager";

    private static ThreadLocal<EntityManager> jpaEntityManagers = new ThreadLocal<>();

    public static EntityManager newEntityManagerInstance() {
        EntityManager entityManager = jpaEntityManagers.get();
        if (entityManager == null) {
            entityManager = Persistence.createEntityManagerFactory(jpaEntityManager).createEntityManager();
            jpaEntityManagers.set(entityManager);
        }
        return entityManager;
    }

    public static void closeEntityManager(EntityManager entityManager) {
        if (entityManager != null) {
            entityManager.close();
        }
    }
}
