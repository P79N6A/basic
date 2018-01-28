package com.itcast.basic.mybatis.tool.blob.mapper;

import com.itcast.basic.mybatis.tool.blob.model.File;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/1/21.
 */
public interface FileMapper {

    int insertFile(File file);

    File findFileById(@Param("id") long id);
}
