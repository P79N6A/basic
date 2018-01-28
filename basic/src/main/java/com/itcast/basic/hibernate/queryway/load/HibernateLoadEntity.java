package com.itcast.basic.hibernate.queryway.load;

import com.itcast.basic.hibernate.queryway.initdata.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * Created by qfl on 16/7/10.
 */
public class HibernateLoadEntity {
    Configuration configuration = new Configuration()
            .configure("com/itcast/basic/hibernate/queryway/hibernate.cfg.xml");
    SessionFactory factory = configuration.buildSessionFactory();
    Session session = factory.openSession();
    User user = (User) session.get(User.class, 1);
//        System.out.println(u.getName());
}
