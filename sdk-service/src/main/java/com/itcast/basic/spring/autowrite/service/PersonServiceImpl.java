package com.itcast.basic.spring.autowrite.service;

import com.itcast.basic.spring.autowrite.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by treey.qian on 2017/11/22.
 */
public class PersonServiceImpl {

    @Autowired
    private PersonDao personDao;

    public void savePerson() {
        System.out.println("enter into PersonServiceImpl" + personDao);
        personDao.save();
        System.out.println("enter into PersonServiceImpl" + personDao);

    }
}
