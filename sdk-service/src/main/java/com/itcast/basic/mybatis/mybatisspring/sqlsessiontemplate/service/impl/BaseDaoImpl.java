package com.itcast.basic.mybatis.mybatisspring.sqlsessiontemplate.service.impl;

import org.mybatis.spring.SqlSessionTemplate;

/**
 * Created by treey.qian on 2018/1/15.
 */
public class BaseDaoImpl {
    private SqlSessionTemplate sqlSessionTemplate;

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
}
