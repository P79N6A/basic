package com.itcast.basic.web.response;

import com.sdk.common.model.SortColumn;

/**
 * Created by treey.qian on 2018/1/29.
 */
public class Condition extends Page {

    //排序字段集
    protected SortColumn sortColumn;

    //返回字段集
    protected String resultColumns;

    public SortColumn getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(SortColumn sortColumn) {
        this.sortColumn = sortColumn;
    }

    public String getResultColumns() {
        return resultColumns;
    }

    public void setResultColumns(String resultColumns) {
        this.resultColumns = resultColumns;
    }
}
