package com.itcast.basic.spring.dubbo.validation.service;

import com.itcast.basic.spring.dubbo.validation.model.ValidationParameter;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;

public interface ValidationService { // 缺省可按服务接⼝区分验证场景，如：@NotNull(groups = ValidationService.class)

    @interface Save {
    } // 与⽅法同名接⼝，⾸字⺟⼤写，⽤于区分验证场景，如：@NotNull(groups = ValidationService.Save.class)，可选

    void save(@NotNull ValidationParameter parameter);

    @GroupSequence(Save.class)
            // 同时验证Save组规则
    @interface Update {
    }

    void update(@NotNull ValidationParameter parameter);

    void delete(int id);
}
