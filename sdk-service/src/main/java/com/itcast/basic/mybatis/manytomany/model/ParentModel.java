package com.itcast.basic.mybatis.manytomany.model;

import java.util.List;

/**
 * Created by Administrator on 2018/1/21.
 */
public class ParentModel {
    private long id;
    private String name;
    private long childrenId;
    private List<ChildrenModel> childrenModelList;


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

    public long getChildrenId() {
        return childrenId;
    }

    public void setChildrenId(long childrenId) {
        this.childrenId = childrenId;
    }

    public List<ChildrenModel> getChildrenModelList() {
        return childrenModelList;
    }

    public void setChildrenModelList(List<ChildrenModel> childrenModelList) {
        this.childrenModelList = childrenModelList;
    }


    @Override
    public String toString() {
        return "ParentModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", childrenId=" + childrenId +
                ", childrenModelList=" + childrenModelList +
                '}';
    }
}
