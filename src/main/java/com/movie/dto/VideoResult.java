package com.movie.dto;

import com.movie.enums.VideoEnum;

import java.io.Serializable;

/**
 * 自定义响应对象
 */
public class VideoResult implements Serializable{
    // 响应业务状态码
    private String state;
    // 响应消息
    private String msg;
    //响应数据
    private Object data;

    private VideoResult() {
    }

    public static VideoResult build(VideoEnum videoEnum, Object data){
        VideoResult videoResult = new VideoResult();
        videoResult.setState(videoEnum.getState());
        videoResult.setMsg(videoEnum.getMsg());
        videoResult.setData(data);
        return  videoResult;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
