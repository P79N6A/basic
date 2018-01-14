package com.itcast.basic.mybatis.mapperdetail.resultmapdetail.service;

import com.itcast.basic.mybatis.mapperdetail.resultmapdetail.model.Student;

import java.util.Map;

/**
 * Created by treey.qian on 2018/1/10.
 */
public interface StudentMapper {

    Student selectUserById(long id);

    Student selectUserAliasById(long id);

    Map selectMapById(long id);
}
