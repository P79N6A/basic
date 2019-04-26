package com.vip.vpal.basereport.repository;

import com.vip.vpal.basereport.entity.PrsCalcResult;

public interface PrsCalcResultMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PrsCalcResult record);

    int insertSelective(PrsCalcResult record);

    PrsCalcResult selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PrsCalcResult record);

    int updateByPrimaryKey(PrsCalcResult record);
}