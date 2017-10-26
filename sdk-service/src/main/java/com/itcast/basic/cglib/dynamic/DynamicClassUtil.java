package com.itcast.basic.cglib.dynamic;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;

import java.io.Serializable;

/**
 * Created by treey.qian on 2017/10/26.
 */
public abstract class DynamicClassUtil implements Serializable {
    private final Log logger = LogFactory.getLog(DynamicClassUtil.class);

    public abstract void executeInternal(JobExecutionContext context);

    public void logger() {
        logger.info("执行日志写入");
    }
}
