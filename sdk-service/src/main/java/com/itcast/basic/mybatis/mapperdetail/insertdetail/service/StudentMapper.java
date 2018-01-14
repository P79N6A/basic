package com.itcast.basic.mybatis.mapperdetail.insertdetail.service;


import com.itcast.basic.mybatis.mapperdetail.insertdetail.model.Sex;
import com.itcast.basic.mybatis.mapperdetail.insertdetail.model.Student;
import org.apache.ibatis.annotations.Param;

/**
 * Created by treey.qian on 2018/1/9.
 */
public interface StudentMapper {
    int insertStudent(Student student);

    int insertShareStudent(Student student);

    int updateNameAndSexOfStudentById(@Param("name") String name, @Param("sex") Sex sex, @Param("id") long id);

    int deleteStudentById(long id);
}
