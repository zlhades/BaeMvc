package com.demo.domain;


import com.demo.utils.Constants;



public class Pagination {
    private int pageNow = 1;
    private Long totalSize;
    private int pageSize = Constants.PAGE_SIZE;

    public Pagination(){}

    public Pagination(int pageSize){
       this.pageSize = pageSize;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public boolean isHasNext() {
        return this.getPageNow() < getTotalPage() ;
    }

    public boolean isHasPre() {
        return this.getPageNow() - 1 > 0;
    }


    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getFirstRecord() {
        return (this.pageNow - 1) * this.pageSize;
    }

    public int getTotalPage() {
        return (this.getTotalSize().intValue() + this.getPageSize() - 1) /this.getPageSize();
    }
}
