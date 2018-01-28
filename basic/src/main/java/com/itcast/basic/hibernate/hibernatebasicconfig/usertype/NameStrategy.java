package com.itcast.basic.hibernate.hibernatebasicconfig.usertype;

import org.hibernate.cfg.ImprovedNamingStrategy;

/**
 * Created by qfl on 16/7/6.
 */
public class NameStrategy extends ImprovedNamingStrategy {
    @Override
    public String tableName(String tableName) {
        return tableName;
    }

    @Override
    public String columnName(String columnName) {
        return columnName;
    }

    @Override
    public String propertyToColumnName(String propertyName) {
        return propertyName.replace(".", "_").toLowerCase();
    }

    @Override
    public String classToTableName(String className) {
        return new StringBuffer()
                .append("t_")
                .append(org.hibernate.util.StringHelper.unqualify(className).toLowerCase())
                .append("s")
                .toString();
    }
}
