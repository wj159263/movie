package com.movie.dto;

import java.io.Serializable;

public class EyUIGridResult implements Serializable {
    private Object rows;
    private long total;

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
