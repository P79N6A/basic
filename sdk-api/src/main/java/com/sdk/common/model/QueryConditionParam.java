package com.sdk.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/28.
 */
public class QueryConditionParam extends ConditionParam implements Serializable {

    //序列号
    private static final long serialVersionUID = 1L;

    //返回列
    private List<String> columns = new ArrayList<String>();

    //排序集
    private List<SortColumn> sortColumns = new ArrayList<SortColumn>();

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


    public QueryConditionParam() {
    }

    public QueryConditionParam(int offset, int fetchSize, List<String> columns, List<SortColumn> sortColumns) {
        this.offset = offset;
        this.fetchSize = fetchSize;
        this.columns = columns;
        this.sortColumns = sortColumns;
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
        return "QueryConditionParam{" +
                "offset=" + offset +
                ", fetchSize=" + fetchSize +
                ", columns=[ " + columnsBuilder.toString() + " ]" +
                ", sortColumns= [ " + sortColumnsBuilder.toString() + " ]" +
                ", condition=" + condition +
                '}';
    }
}
