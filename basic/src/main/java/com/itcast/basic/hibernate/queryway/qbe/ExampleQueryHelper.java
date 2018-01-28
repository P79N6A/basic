package com.itcast.basic.hibernate.queryway.qbe;

import com.itcast.basic.hibernate.queryway.UtilHelper;
import com.itcast.basic.hibernate.queryway.initdata.Sex;
import com.itcast.basic.hibernate.queryway.initdata.User;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

import java.util.List;

/**
 * Created by qfl on 16/7/11.
 */
public class ExampleQueryHelper {

    public static void qbeDemo() {
        int pageIndex = 0;
        int pageSize = 20;
        Session session = UtilHelper.getQuerySession("com/itcast/basic/hibernate/queryway/hibernate.cfg.xml");

        User user = new User();
        user.setName("lil%");
        user.setSex(Sex.MAN);

        Example example = Example.create(user)
                .ignoreCase()
                .excludeProperty("id")
                .excludeZeroes()
                .enableLike(MatchMode.END);

        List<User> users = session.createCriteria(User.class)
                .add(example)
                .setFirstResult(pageIndex)
                .setMaxResults(pageSize)
                .list();
    }
}










