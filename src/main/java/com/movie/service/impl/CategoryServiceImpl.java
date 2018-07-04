package com.movie.service.impl;

import com.movie.mapper.CategoryMapper;
import com.movie.pojo.Category;
import com.movie.pojo.CategoryExample;
import com.movie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<Category> selectAll() {
        CategoryExample example = new CategoryExample();
        return categoryMapper.selectByExample(example);
    }
}
