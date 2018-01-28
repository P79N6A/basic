package com.itcast.basic.spring.config.transcation;

import java.util.List;

/**
 * Created by qfl on 16/7/31.
 */
public interface GeneratorDao {
    List query(String sql);
}
