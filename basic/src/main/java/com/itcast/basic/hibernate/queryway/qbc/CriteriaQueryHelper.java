package com.itcast.basic.hibernate.queryway.qbc;

import com.itcast.basic.hibernate.queryway.UtilHelper;
import com.itcast.basic.hibernate.queryway.initdata.User;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transaction.ResinTransactionManagerLookup;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;

import java.util.List;

/**
 * Created by qfl on 16/7/10.
 */
public class CriteriaQueryHelper {

    public static void qbcDemo() {

        int pageIndex = 0;
        int pageSize = 20;
        Session session = UtilHelper.getQuerySession("com/itcast/basic/hibernate/queryway/hibernate.cfg.xml");
        /**
         * 常见query by criteria语句
         */
        List results = session.createCriteria(User.class)
                .add(Restrictions.between("age", 18, 25))
                .add(Restrictions.and(Restrictions.gt("customePrice", 200), Restrictions.lt("stocks", 30)))
                .add(Restrictions.like("name", "li", MatchMode.END).ignoreCase())
                .add(Restrictions.in("feature", new String[]{"watching", "swimming", "playing"}))
                .add(Restrictions.isEmpty("orders"))
                .add(Restrictions.isNotNull("id"))
                .addOrder(Order.asc("age"))
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
                .setFirstResult(pageIndex)
                .setMaxResults(pageSize)
                .list();
    }
}
