package com.itcast.basic.spring.timer.invoke;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by treey.qian on 2017/10/26.
 */
public class JobTask {

    private final Log logger = LogFactory.getLog(JobTask.class);


    public void doJob() {
        logger.info("JobTask begin run doJob");
    }
}
