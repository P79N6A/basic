package com.sdk.common.util;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Created by Administrator on 2018/1/28.
 */
public class BeanMapperFactory {
    public static MapperFacade initBeanMapper() {
        return new DefaultMapperFactory.Builder().build().getMapperFacade();
    }
}
