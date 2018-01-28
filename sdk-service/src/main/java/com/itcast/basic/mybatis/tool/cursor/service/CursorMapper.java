package com.itcast.basic.mybatis.tool.cursor.service;

import com.itcast.basic.mybatis.tool.cursor.model.ParamModel;

/**
 * Created by Administrator on 2018/1/21.
 */
public interface CursorMapper {
    void query(ParamModel paramModel);
}
