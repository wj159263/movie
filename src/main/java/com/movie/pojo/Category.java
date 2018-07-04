package com.movie.pojo;

import java.io.Serializable;

public class Category implements Serializable {
    private Byte cId;

    private String cName;

    private Byte isParent;

    private Byte parentId;

    public Byte getcId() {
        return cId;
    }

    public void setcId(Byte cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public Byte getIsParent() {
        return isParent;
    }

    public void setIsParent(Byte isParent) {
        this.isParent = isParent;
    }

    public Byte getParentId() {
        return parentId;
    }

    public void setParentId(Byte parentId) {
        this.parentId = parentId;
    }
}