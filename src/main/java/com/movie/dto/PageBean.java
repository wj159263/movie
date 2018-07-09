package com.movie.dto;

import java.io.Serializable;

public class PageBean<T> implements Serializable {
    private int page; //当前页
    private int totalPage; //总页数
    private int rows; //一页记录数
    private int start; //开始行数
    private int totalRecords; //总记录数
    private String keyword; //关键字，用于搜索
    private T entityPram; //用于多条件查询

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        if (page <= 0){
           this.page = 1;
        }
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getStart() {
        start = (page - 1) * rows ;
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public T getEntityPram() {
        return entityPram;
    }

    public void setEntityPram(T entityPram) {
        this.entityPram = entityPram;
    }
}
