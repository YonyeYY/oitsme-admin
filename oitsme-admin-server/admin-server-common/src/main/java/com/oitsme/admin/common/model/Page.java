package com.oitsme.admin.common.model;

import java.io.Serializable;

public class Page implements Serializable{
    private static final long serialVersionUID = 6859651188997142908L;

    protected String orderByClause;
    protected boolean distinct = false;
    protected Integer startWith = 0;
    protected Integer endWith = 20;
    
    public static Integer getmysqlStartIndex(Integer page, Integer rows){
        return page < 1 ? 0 : (page - 1) * rows ;
    }
    
    public static Integer getStartIndex(Integer page, Integer rows){
        return page < 1 ? 0 : (page - 1) * rows + 1;
    }

    public static Integer getEndIndex(Integer page, Integer rows){
        return page < 1 ? rows : page * rows;
    }

    public static Long getTotalPage(Long records, Integer rows){
        return (records%rows) == 0 ? (records/rows) : (records/rows) + 1;
    }

    public Page() {
    }

    public Page(Integer startWith, Integer endWith) {
        this.startWith = startWith;
        this.endWith = endWith;
    }

    public Page(String orderByClause, Integer startWith, Integer endWith) {
        this.orderByClause = orderByClause;
        this.startWith = startWith;
        this.endWith = endWith;
    }

    public Page(String orderByClause, boolean distinct, Integer startWith, Integer endWith) {
        this.orderByClause = orderByClause;
        this.distinct = distinct;
        this.startWith = startWith;
        this.endWith = endWith;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public Integer getStartWith() {
        return startWith;
    }

    public void setStartWith(Integer startWith) {
        this.startWith = startWith;
    }

    public Integer getEndWith() {
        return endWith;
    }

    public void setEndWith(Integer endWith) {
        this.endWith = endWith;
    }
}
