package com.sdk.common.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/28.
 */
public class SortColumn implements Serializable {

    private String column;
    private String sort;

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public SortColumn(String column, String sort) {
        this.column = column;
        this.sort = sort;
    }

    public SortColumn() {
    }

    @Override
    public String toString() {
        return "SortColumn{" +
                "column='" + column + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }
}
