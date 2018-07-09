package com.test;

import com.movie.dto.VideoResult;
import com.movie.enums.VideoEnum;

public class EnumTest {
    public static void main(String[] args) {
        VideoResult videoResult = VideoResult.build(VideoEnum.SUCCESS, "111");
        if(videoResult.getState().equals("200")){
            System.out.println(videoResult.getMsg());
        }
    }
}
