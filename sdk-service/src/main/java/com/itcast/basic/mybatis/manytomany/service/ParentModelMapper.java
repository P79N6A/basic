package com.itcast.basic.mybatis.manytomany.service;

import com.itcast.basic.mybatis.manytomany.model.ParentModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/1/21.
 */
public interface ParentModelMapper {
    int insertParentModel(ParentModel parentModel);

    ParentModel findById(@Param("id") long id);

    List<ParentModel> findByChildrenId(@Param("childrenId") long childrenId);
}

