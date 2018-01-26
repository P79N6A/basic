package com.itcast.basic.spring.tools.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by treey.qian on 2018/1/26.
 */
public class MongoDBServiceImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

    public boolean insertData(Object json, String tableName) {
        mongoTemplate.insert(json, tableName);
        return true;
    }
}
