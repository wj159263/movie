package com.movie.service.impl;

import com.movie.dto.EyUIGridResult;
import com.movie.dto.EyuiDatagridLoop;
import com.movie.dto.VideoResult;
import com.movie.enums.VideoEnum;
import com.movie.mapper.CenterLoopMapper;
import com.movie.pojo.CenterLoop;
import com.movie.pojo.CenterLoopExample;
import com.movie.service.CenterLoopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CenterLoopServiceImpl implements CenterLoopService{

    @Autowired
    private CenterLoopMapper centerLoopMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false,rollbackFor = Exception.class)
    public VideoResult insertRecords(String[] ids, String[] imgs) throws Exception {
        //遍历，添加记录
        for(int index = 0; index < ids.length; index++){
            CenterLoop loop = new CenterLoop();
            loop.setVideoId(ids[index]);
            loop.setImage(imgs[index]);
            int row = centerLoopMapper.insert(loop);
            //当添加记录不等1时，出现错误
            if(row != 1){
                throw new Exception("轮播图添加数据错误");
            }
        }
        return VideoResult.build(VideoEnum.SUCCESS,ids.length);
    }

    @Override
    public EyUIGridResult selectList(int page, int rows) throws Exception {
        if(page < 1){
            page = 1;
        }
        //开始记录数
        int start = (page - 1) * rows;
        List<EyuiDatagridLoop> loops = centerLoopMapper.selectList(start, rows);
        CenterLoopExample example = new CenterLoopExample();
        int i = centerLoopMapper.countByExample(example);
        //封装成easyui的datagrid格式数据
        EyUIGridResult eyUIGridResult = new EyUIGridResult();
        eyUIGridResult.setRows(loops);
        eyUIGridResult.setTotal(i);
        return eyUIGridResult;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public VideoResult deleteBatch(String[] ids) throws Exception {
        //数组非空判断
        if(ids != null && ids.length > 0){
            for(String id : ids){
                CenterLoopExample example = new CenterLoopExample();
                example.createCriteria().andVideoIdEqualTo(id);
                int row = centerLoopMapper.deleteByExample(example);
                //如果数据库影响行数不为1
                if (row != 1){
                    throw new Exception("轮播图记录删除失败!");
                }
            }
        }
        return VideoResult.build(VideoEnum.SUCCESS, ids.length);
    }


}
