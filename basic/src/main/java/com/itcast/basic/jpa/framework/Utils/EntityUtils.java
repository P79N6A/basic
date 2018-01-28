package com.itcast.basic.jpa.framework.Utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by qfl on 16/6/10.
 */
public class EntityUtils {
    public static final String DBNAME = "itcast";
    private static ThreadLocal<EntityManager> locals = new ThreadLocal<>();

    public static EntityManager getEntityManager(String name) {
        EntityManager manager = locals.get();
        if (manager == null) {
            manager = Persistence.createEntityManagerFactory(name).createEntityManager();
            locals.set(manager);
        }
        return manager;
    }

    public static void closeEntityManager(EntityManager manager) {
        if (manager != null)
            manager.close();
    }
}
