package com.itcast.basic.spring.quartz.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;
import java.util.Set;

/**
 * Created by treey.qian on 2017/10/25.
 */
public class JobService {
    private final Log logger = LogFactory.getLog(JobService.class);

    public void doJob(Map jobDataMap) {
        logger.info("开始执行定时任务");
        for (Map.Entry entry : (Set<Map.Entry>) jobDataMap.entrySet()) {
            logger.info(entry.getKey() + "----->" + entry.getValue());
        }
    }
}
