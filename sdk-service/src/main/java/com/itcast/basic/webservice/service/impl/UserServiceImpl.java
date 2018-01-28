package com.itcast.basic.webservice.service.impl;


import com.itcast.basic.webservice.entity.User;
import com.itcast.basic.webservice.repository.UserRepository;
import com.sdk.common.model.ConditionParam;
import com.sdk.model.UserModel;
import com.sdk.service.UserService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by treey.qian on 2018/1/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MapperFacade beanMapper;

    @Override
    @Transactional(readOnly = true)
    public int countCondition(ConditionParam conditionParam) {
        return userRepository.countCondition(conditionParam);
    }

    @Override
    @Transactional
    public int insert(UserModel userModel) {
        return userRepository.insert(beanMapper.map(userModel, User.class));
    }

    @Override
    @Transactional
    public int deleteById(long id) {
        return userRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public UserModel findUserModelById(long id) {
        return beanMapper.map(userRepository.findUserById(id), UserModel.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserModel> findUserModelsByCondition(ConditionParam conditionParam) {
        return beanMapper.mapAsList(userRepository.findUsersByCondition(conditionParam), UserModel.class);
    }

    @Override
    @Transactional
    public int updateUserModelById(UserModel userModel) {
        return userRepository.updateUserById(beanMapper.map(userModel, User.class));
    }
}
