package com.itcast.basic.mybatis.joindetail.service;

import com.itcast.basic.mybatis.joindetail.model.TeacherCard;

/**
 * Created by treey.qian on 2018/1/10.
 */
public interface TeacherCardMapper {
    int insertTeacherCard(TeacherCard teacherCard);

    TeacherCard selectTeacherCardById(long id);

    TeacherCard selectTeacherCardByTeacherId(long teacherId);
}
