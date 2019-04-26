package com.vip.vpal.basereport.repository;

import com.vip.vpal.basereport.entity.PrsTableParaConfig;

public interface PrsTableParaConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PrsTableParaConfig record);

    int insertSelective(PrsTableParaConfig record);

    PrsTableParaConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PrsTableParaConfig record);

    int updateByPrimaryKey(PrsTableParaConfig record);
}