package com.itcast.basic.mybatis.manytomany.service;

import com.itcast.basic.mybatis.manytomany.model.ChildrenModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/1/21.
 */
public interface ChildrenModelMapper {

    int insertChildrenModel(ChildrenModel childrenModel);

    ChildrenModel findById(@Param("id") long id);

    List<ChildrenModel> findByParentId(@Param("parentId") long parentId);
}

