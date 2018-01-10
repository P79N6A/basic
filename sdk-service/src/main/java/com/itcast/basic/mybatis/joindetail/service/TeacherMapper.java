package com.itcast.basic.mybatis.joindetail.service;

import com.itcast.basic.mybatis.joindetail.model.Teacher;

/**
 * Created by treey.qian on 2018/1/10.
 */
public interface TeacherMapper {
    int insertTeacher(Teacher teacher);

    Teacher selectTeacherById(long id);
}
