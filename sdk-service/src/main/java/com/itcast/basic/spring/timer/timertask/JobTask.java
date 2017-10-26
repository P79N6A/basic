package com.itcast.basic.spring.timer.timertask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.TimerTask;

/**
 * Created by treey.qian on 2017/10/26.
 */
public class JobTask extends TimerTask {

    private final Log logger = LogFactory.getLog(JobTask.class);

    @Override
    public void run() {
         logger.info("JobTask begin run");
    }
}
