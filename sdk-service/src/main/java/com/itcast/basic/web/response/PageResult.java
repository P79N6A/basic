package com.itcast.basic.web.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/28.
 */
public class PageResult extends Page {

    //查询总数
    private int total;
    //总共页码
    private int totalPages;
    //结果集
    private List result;

    public PageResult() {
    }

    public PageResult(int total, int totalPages, int currentPage, int pageSize, List result) {
        super(currentPage, pageSize);
        this.total = total >= 0 ? total : 0;
        this.totalPages = totalPages >= 0 ? totalPages : 0;
        this.result = result == null ? new ArrayList() : result;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
