package com.vip.vpal.basereport.repository;

import com.vip.vpal.basereport.entity.BankCapitalFlow;

public interface BankCapitalFlowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BankCapitalFlow record);

    int insertSelective(BankCapitalFlow record);

    BankCapitalFlow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BankCapitalFlow record);

    int updateByPrimaryKey(BankCapitalFlow record);
}