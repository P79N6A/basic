package com.sdk.service;

import com.sdk.common.model.ConditionParam;
import com.sdk.model.UserModel;

import java.util.List;

/**
 * Created by Administrator on 2018/1/28.
 */
public interface UserService {

    int countCondition(ConditionParam conditionParam);

    int insert(UserModel userModel);

    int deleteById(long id);

    UserModel findUserModelById(long id);

    List<UserModel> findUserModelsByCondition(ConditionParam conditionParam);

    int updateUserModelById(UserModel userModel);
}
