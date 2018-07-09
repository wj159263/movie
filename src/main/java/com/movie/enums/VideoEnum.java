package com.movie.enums;

public enum VideoEnum {
    SUCCESS("200","操作成功"),
    FAIL("400","操作失败");

    private String state;
    private String msg;

    private VideoEnum (String state, String msg){
        this.state = state;
        this.msg = msg;
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

    public static VideoEnum stateOf(String state) {
        for (VideoEnum statEnum : values()) {
            if (state.equals(statEnum.getState())) {
                return statEnum;
            }
        }
        return null;
    }
}
