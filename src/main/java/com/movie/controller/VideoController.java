package com.movie.controller;

import com.movie.dto.EyUIGridResult;
import com.movie.dto.VideoPortalDto;
import com.movie.dto.VideoResult;
import com.movie.enums.VideoEnum;
import com.movie.pojo.Category;
import com.movie.pojo.User;
import com.movie.pojo.Video;
import com.movie.pojo.VideoDetail;
import com.movie.service.CategoryService;
import com.movie.service.CenterLoopService;
import com.movie.service.VideoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    CenterLoopService centerLoopService;

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
        //todo 临时用，日后要修改
        videoDetail.setUserId("2");
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

    @RequestMapping("/sudo/deletebatch")
    @ResponseBody
    public VideoResult deletebachByIds(String[] ids)throws Exception{
        return videoService.deletebachByIds(ids);
    }
//-*************portal页面的后台方法********************
    @RequestMapping("/portal")
    public String showPortalIndex(Model model)throws Exception{
        List<VideoPortalDto> value = videoService.selectVideosSimple();
        List<Category> result = categoryService.selectCategories();
        EyUIGridResult result1 = centerLoopService.selectList(1,100);
        model.addAttribute("centerLoopList",result1.getRows());
        model.addAttribute("videoList",value);
        model.addAttribute("categories",result);
        return "portal/index";
    }

    @RequestMapping("/selectSyc/{id}")
    public String selectVideoById(Model model, @PathVariable("id") String id){
        Video video= videoService.selectVideoById(id);
        model.addAttribute("video",video);
        return "portal/movie-detail";
    }

    @RequestMapping("/selectByName")
    public String selectByName(Model model, String videoName){
        if (StringUtils.isNoneBlank(videoName.trim())){
            List<Video> videos = videoService.selectByName(videoName);
            if(videos != null && videos.size () >0) {
                model.addAttribute("video", videos.get(0));
                return "portal/movie-detail";
            }
        }
        return null;
    }
}
