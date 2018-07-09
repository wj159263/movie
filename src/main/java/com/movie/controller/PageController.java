package com.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/{page}")
    public String toPage(@PathVariable("page")String page){
        return page;
    }

    @RequestMapping("/{direct}/{page}")
    public String toPage(@PathVariable("direct")String direct, @PathVariable("page")String page){
        return direct + "/" + page;
    }
}
