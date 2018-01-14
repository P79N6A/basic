package com.itcast.basic.mybatis.joindetail.service;

import com.itcast.basic.mybatis.joindetail.model.FemaleTeacherHealth;
import com.itcast.basic.mybatis.joindetail.model.ManTeacherHealth;

/**
 * Created by treey.qian on 2018/1/10.
 */
public interface TeacherHealthMapper {

    int insertManTeacherHealth(ManTeacherHealth manTeacherHealth);

    int insertFemaleTeacherHealth(FemaleTeacherHealth femaleTeacherHealth);

    ManTeacherHealth selectManTeacherHealthById(long id);

    FemaleTeacherHealth selectFemaleTeacherHealthById(long id);

    ManTeacherHealth selectManTeacherHealthByTeachId(long teacherId);

    FemaleTeacherHealth selectFemaleTeacherHealthByTeacherId(long teacherId);
}
