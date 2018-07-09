package com.movie.service;

import com.movie.pojo.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 根据父id查找子节点类目
     * @param id 父类目id
     * @return easyui组建所求的返回格式
     */
    public List selectAll(byte id);
}
