package com.movie.dto;

import com.movie.pojo.CenterLoop;

import java.io.Serializable;

public class EyuiDatagridLoop extends CenterLoop implements Serializable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
