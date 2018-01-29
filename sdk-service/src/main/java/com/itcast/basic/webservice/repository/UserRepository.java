package com.itcast.basic.webservice.repository;

import com.itcast.basic.webservice.entity.User;
import com.sdk.common.model.ConditionParam;
import com.sdk.common.model.QueryConditionParam;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/1/14.
 */
@Repository
public interface UserRepository {

    int insert(User user);

    int deleteById(long id);

    User findUserById(long id);

    List<User> findUsersByCondition(QueryConditionParam conditionParam);

    int countCondition(ConditionParam conditionParam);

    int updateUserById(User user);
}
