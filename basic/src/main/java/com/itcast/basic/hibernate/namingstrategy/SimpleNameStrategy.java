package com.itcast.basic.hibernate.namingstrategy;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.util.StringHelper;

/**
 * Created by qfl on 16/7/5.
 */
public class SimpleNameStrategy extends ImprovedNamingStrategy {
    /**
     * 配置文件没有显式声明column时调用
     *
     * @param propertyName
     * @return
     */
    @Override
    public String propertyToColumnName(String propertyName) {
        return propertyName.replace(".", "_").toLowerCase();
    }

    @Override
    public String classToTableName(String className) {
        return new StringBuffer()
                .append("t_")
                .append(StringHelper.unqualify(className).toLowerCase())
                .toString();
    }

    /**
     * 配置文件显式声明column时调用
     *
     * @param tableName
     * @return
     */
    @Override
    public String tableName(String tableName) {
        return tableName;
    }

    @Override
    public String columnName(String columnName) {
        return columnName;
    }
}
