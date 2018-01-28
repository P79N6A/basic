package com.itcast.basic.spring.annatation.annationbasicconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by qfl on 16/7/31.
 */
@Configuration
public class ControllerUtils {
    @Bean
    public UserController operateByUserController() {
        return new UserController();
    }
}
