package com.ranying.common;

import java.io.Serializable;

public class PageParam implements Serializable {

    private Integer limit;

    private Integer offset;

    private Integer pageNumber;

    private Integer pageSize;

    public Integer getLimit() {
        if (limit == null || limit < 0) {
            return 10;
        }
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        if (offset == null || offset < 0) {
            return 0;
        }
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getPageNumber() {
        return (offset / limit) + 1;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return getLimit();
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
