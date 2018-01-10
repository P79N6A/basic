package com.itcast.basic.mybatis.joindetail.service;

import com.itcast.basic.mybatis.joindetail.model.Lesson;

import java.util.List;

/**
 * Created by treey.qian on 2018/1/10.
 */
public interface LessonMapper {
    int insertLesson(Lesson lesson);

    Lesson selectLessonById(long id);

    List<Lesson> selectLessonByTeacherId(long teacherId);
}
