package com.sdk.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/28.
 */
public class ConditionParam<T> implements Serializable {

    //序列号
    private static final long serialVersionUID = 1L;

    //数据偏倚量
    private int offset = 0;

    //页大小
    private int fetchSize = 0;

    //返回列
    private List<String> columns = new ArrayList<String>();

    //排序集
    private List<SortColumn> sortColumns = new ArrayList<SortColumn>();

    //查询条件
    private T condition;


    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getFetchSize() {
        return fetchSize;
    }

    public void setFetchSize(int fetchSize) {
        this.fetchSize = fetchSize;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public List<SortColumn> getSortColumns() {
        return sortColumns;
    }

    public void setSortColumns(List<SortColumn> sortColumns) {
        this.sortColumns = sortColumns;
    }

    public T getCondition() {
        return condition;
    }

    public void setCondition(T condition) {
        this.condition = condition;
    }

    public ConditionParam() {
    }

    public ConditionParam(int offset, int fetchSize, List<String> columns, List<SortColumn> sortColumns, T condition) {
        this.offset = offset;
        this.fetchSize = fetchSize;
        this.columns = columns;
        this.sortColumns = sortColumns;
        this.condition = condition;
    }

    @Override
    public String toString() {

        StringBuilder columnsBuilder = new StringBuilder();
        for (String column : columns) {
            columnsBuilder.append(column).append(" ");
        }

        StringBuilder sortColumnsBuilder = new StringBuilder();
        for (SortColumn sortColumn : sortColumns) {
            sortColumnsBuilder.append(sortColumn.toString()).append(" ");
        }
        return "ConditionParam{" +
                "offset=" + offset +
                ", fetchSize=" + fetchSize +
                ", columns=[ " + columnsBuilder.toString() + " ]" +
                ", sortColumns= [ " + sortColumnsBuilder.toString() + " ]" +
                ", condition=" + condition +
                '}';
    }
}
