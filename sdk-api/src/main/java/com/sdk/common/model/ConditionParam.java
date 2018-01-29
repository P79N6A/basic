package com.sdk.common.model;

import java.io.Serializable;

/**
 * Created by treey.qian on 2018/1/29.
 */
public class ConditionParam<T> implements Serializable {
    //序列号
    private static final long serialVersionUID = 1L;

    //数据偏倚量
    protected int offset = 0;

    //页大小
    protected int fetchSize = 0;

    //查询条件
    protected T condition;

    public ConditionParam(int offset, int fetchSize, T condition) {
        this.offset = offset;
        this.fetchSize = fetchSize;
        this.condition = condition;
    }

    public ConditionParam() {
    }

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

    public T getCondition() {
        return condition;
    }

    public void setCondition(T condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "ConditionParam{" +
                "offset=" + offset +
                ", fetchSize=" + fetchSize +
                ", condition=" + condition +
                '}';
    }
}
