package com.itcast.basic.mybatis.manytomany.model;

import java.util.List;

/**
 * Created by Administrator on 2018/1/21.
 */
public class ChildrenModel {

    private long id;
    private String name;
    private long parentId;
    private List<ParentModel> parentModelList;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public List<ParentModel> getParentModelList() {
        return parentModelList;
    }

    public void setParentModelList(List<ParentModel> parentModelList) {
        this.parentModelList = parentModelList;
    }
}
