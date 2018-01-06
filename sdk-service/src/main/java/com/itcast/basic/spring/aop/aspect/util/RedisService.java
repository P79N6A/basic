package com.itcast.basic.spring.aop.aspect.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * Created by treey.qian on 2017/10/16.
 */
@Service
public class RedisService {
    private final Log log = LogFactory.getLog(RedisService.class);

    public void createCache() {
        log.info("create redis cache");
    }

    public void updateCache() {
        log.info("update redis cache");
    }

    public void deleteCache() {
        log.info("delete redis cache");
    }
}
