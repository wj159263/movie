package com.movie.controller;

import com.movie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List selectAll(@RequestParam(value="id",defaultValue="0")byte id){
        return categoryService.selectAll(id);
    }
}
