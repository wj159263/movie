package com.movie.controller;

import com.movie.dto.EyUIGridResult;
import com.movie.dto.VideoResult;
import com.movie.enums.VideoEnum;
import com.movie.pojo.User;
import com.movie.pojo.Video;
import com.movie.pojo.VideoDetail;
import com.movie.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    VideoService videoService;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/sudo/insert",method = RequestMethod.POST)
    @ResponseBody
    public VideoResult insertVideo(Video video, HttpSession session)throws Exception{
        //从session中取上传者id
        User upUser = (User)session.getAttribute("user");
        VideoDetail videoDetail = new VideoDetail();
        if(upUser != null) {
            videoDetail.setUserId(upUser.getUserId());
        }
       return videoService.insertVideo(video, videoDetail);

    }

    @RequestMapping("/list")
    @ResponseBody
    public EyUIGridResult selectVideoList(Integer page, Integer rows, String name) throws Exception {
        return videoService.selectVideoList(page, rows, name);
    }

    @RequestMapping("/sudo/delete/{id}")
    @ResponseBody
    public VideoResult deleteVideo(@PathVariable("id") String id)throws Exception{
        return videoService.deleteVideoById(id);
    }

    @RequestMapping("/select/{id}")
    @ResponseBody
    public Video selectVideoById(@PathVariable("id") String id){
        return videoService.selectVideoById(id);
    }

    @RequestMapping("/sudo/update")
    @ResponseBody
    public VideoResult updateVideoById(Video video, VideoDetail videoDetail)throws Exception{
        return videoService.updateVideoById(video, videoDetail);
    }

    @RequestMapping("/sudo/deletebach")
    @ResponseBody
    public VideoResult deletebachByIds(String[] ids)throws Exception{
        return videoService.deletebachByIds(ids);
    }

}
