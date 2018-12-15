package com.movie.service;

import com.movie.dto.EyUIGridResult;
import com.movie.dto.VideoResult;

public interface CenterLoopService {
    /**
     * 添加轮播图
     * @param ids  多条视频id
     * @param imgs 多条视频的图片
     * @return
     * @throws Exception
     */
    public VideoResult insertRecords(String[] ids, String[] imgs)throws Exception;

    /**
     *
     * @param page 当前页
     * @param rows 每页记录数
     * @return
     * @throws Exception
     */
    public EyUIGridResult selectList(int page, int rows) throws Exception;

    /**
     * 根据id批量删除轮播图记录
     * @param ids 轮播图的视频id
     * @return
     * @throws Exception
     */
    public VideoResult deleteBatch(String[] ids) throws Exception;
}
