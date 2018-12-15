package com.movie.service.impl;

import com.movie.dto.EyUITreeResult;
import com.movie.mapper.CategoryMapper;
import com.movie.pojo.Category;
import com.movie.pojo.CategoryExample;
import com.movie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List selectAll(byte id) {
        CategoryExample example = new CategoryExample();
        example.createCriteria().andParentIdEqualTo(id);
        List<Category> categories = categoryMapper.selectByExample(example);
        ArrayList<Object> reList = new ArrayList<>();
        if(categories != null && categories.size() > 0) {
            //拼装成easyui需要的格式[{x1:y1},{x2:y2}]
            for (Category category : categories) {
                EyUITreeResult treeResult = new EyUITreeResult();
                treeResult.setId(category.getcId() + "");
                treeResult.setText(category.getcName());
                treeResult.setState(category.getIsParent() == 0 ? "open" : "closed");
                reList.add(treeResult);
            }
        }
        return reList;
    }

    @Override
    public List<Category> selectCategories() {
        CategoryExample example =new CategoryExample();
        List<Category> result = categoryMapper.selectByExample(example);
        return result;
    }
}
