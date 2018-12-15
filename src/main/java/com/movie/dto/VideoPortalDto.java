package com.movie.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class VideoPortalDto implements Serializable {
    private String cName;
    private List<Map> dataList;

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public List<Map> getDataList() {
        return dataList;
    }

    public void setDataList(List<Map> dataList) {
        this.dataList = dataList;
    }
}
