package com.itcast.basic.hibernate.queryway.qbs;

import com.itcast.basic.hibernate.queryway.UtilHelper;
import com.itcast.basic.hibernate.queryway.initdata.User;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import java.util.List;

/**
 * Created by qfl on 16/7/10.
 */
public class SqlQueryHelper {

    public static void sqlDemo() {

        Session session = UtilHelper.getQuerySession("com/itcast/basic/hibernate/queryway/hibernate.cfg.xml");
        /**
         * 常见query by criteria语句
         */
        List results = session.createSQLQuery("select id,name,sex from t_users u where u.id is not null and u.age>=18 and u.age<=26 group by status order by liveness desc")
                .setFirstResult(0)
                .setMaxResults(10)
                .setResultTransformer(Transformers.aliasToBean(User.class))
                .list();
    }
}
