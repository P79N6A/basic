package com.itcast.basic.web.response;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/28.
 */
public class Page implements Serializable {

    public static final int DEFAULT_PAGE_SIZE=15;

    public static final int DEFAULT_CURRENT_PAGE=1;

    //当前页码
    protected int currentPage;
    //页大小
    protected int pageSize;

    public Page() {
    }

    public Page(int currentPage, int pageSize) {
        this.currentPage = currentPage >= 0 ? currentPage : 0;
        this.pageSize = pageSize >= 0 ? pageSize : 0;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
