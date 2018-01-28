package com.itcast.basic.mybatis.tool.cursor.model;

import java.util.List;

/**
 * Created by Administrator on 2018/1/21.
 */
public class ParamModel {

    private int count;

    private String condition;

    private List<User> userList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
