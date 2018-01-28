package com.itcast.basic.spring.config.injection;

/**
 * Created by qfl on 16/7/28.
 */
public class PersonService {

    public void savePerson() {
        System.out.println("保存person对象");
    }

    public void deletePerson() {
        System.out.println("删除person对象");
    }

    public void updatePerson() {
        System.out.println("更新person对象");
    }

    public void queryPerson() {
        System.out.println("查询person对象");
    }
}
