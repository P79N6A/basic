package com.vip.vpal.basereport.repository;

import com.vip.vpal.basereport.entity.Generate;

public interface GenerateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Generate record);

    int insertSelective(Generate record);

    Generate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Generate record);

    int updateByPrimaryKey(Generate record);
}