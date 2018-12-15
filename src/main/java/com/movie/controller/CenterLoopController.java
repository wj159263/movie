package com.movie.controller;

import com.movie.dto.EyUIGridResult;
import com.movie.dto.VideoResult;
import com.movie.service.CenterLoopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/loop")
public class CenterLoopController {
    @Autowired
    private CenterLoopService centerLoopService;

    @RequestMapping("/sudo/insert")
    @ResponseBody
    public VideoResult insertRecords(String[] ids, String[] imgs) throws Exception{
       return centerLoopService.insertRecords(ids, imgs);
    }

    @RequestMapping("/list")
    @ResponseBody
    public EyUIGridResult selectList(Integer page, Integer rows) throws Exception {
        return centerLoopService.selectList(page, rows);
    }

    @RequestMapping("/sudo/deletebatch")
    @ResponseBody
    public VideoResult deletebatch(String[] ids) throws Exception {
        return centerLoopService.deleteBatch(ids);
    }
}
