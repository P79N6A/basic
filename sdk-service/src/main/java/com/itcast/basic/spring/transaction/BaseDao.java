package com.itcast.basic.spring.transaction;

import java.util.List;

/**
 * Created by treey.qian on 2017/10/19.
 */
public interface BaseDao {

    List queryForList(String querySql);

}
