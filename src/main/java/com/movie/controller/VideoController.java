package com.movie.controller;

import com.movie.pojo.Video;
import com.movie.pojo.VideoDetail;
import com.movie.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @RequestMapping("/sudo/insert")
    @ResponseBody
    public int insertVideo(Video video, VideoDetail videoDetail){
        return videoService.insertVideo(video, videoDetail);
    }

    @RequestMapping("/sudo/delete/{id}")
    @ResponseBody
    public int deleteVideo(@PathVariable("id") String id){
        return videoService.deleteVideoById(id);
    }

    @RequestMapping("/select/{id}")
    @ResponseBody
    public Video selectVideoById(@PathVariable("id") String id){
        return videoService.selectVideoById(id);
    }

    @RequestMapping("/sudo/update")
    @ResponseBody
    public int updateVideoById(Video video, VideoDetail videoDetail){
        return videoService.updateVideoById(video, videoDetail);
    }

}
