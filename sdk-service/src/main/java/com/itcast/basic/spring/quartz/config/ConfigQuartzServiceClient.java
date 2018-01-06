package com.itcast.basic.spring.quartz.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by treey.qian on 2017/10/25.
 */
public class ConfigQuartzServiceClient {
    private static final Log logger = LogFactory.getLog(ConfigQuartzServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into ConfigQuartzServiceClient");
            final ConfigQuartzSchedulerService configQuartzJobService = new ConfigQuartzSchedulerService();
            configQuartzJobService.start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000);
                        configQuartzJobService.stop();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            logger.info("configQuartzJobService=" + configQuartzJobService);
        } catch (Exception e) {
            logger.info("ConfigQuartzServiceClient error message is {}", e);
        }
    }
}
