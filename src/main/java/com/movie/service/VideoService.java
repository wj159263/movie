package com.movie.service;

import com.movie.dto.EyUIGridResult;
import com.movie.dto.VideoResult;
import com.movie.pojo.Video;
import com.movie.pojo.VideoDetail;

public interface VideoService {
    /**
     * 根据id查询视频
     * @param id 视频id
     * @return Video对象
     */
    public Video selectVideoById(String id);

    /**
     * 根据id查询视频(包含视频介绍)
     * @param id 视频id
     * @return Video对象
     */
    public Video selectVideoByIdWithBlobs(String id);

    /**
     * 查询多条视频
     * @param page easyui组件发送的参数，当前页
     * @param rows easyui组件发送的参数，每页记录数
     * @return easyui组件需求的格式数据
     */
    public EyUIGridResult selectVideoList(int page, int rows, String name) throws Exception;

    /**
     * 添加视频
     * @param video 视频信息
     * @param  videoDetail  要添加的视频详细信息
     * @return  操作结果
     */
    public VideoResult insertVideo(Video video, VideoDetail videoDetail) throws Exception;

    /**
     * 根据id删除视频
     * @param id 视频id
     * @return 操作结果
     */
    public VideoResult deleteVideoById(String id) throws Exception;

    /**
     * 根据多个id批量删除视频
     * @param ids 视频id
     * @return 操作结果
     */
    public VideoResult deletebachByIds(String[] ids)throws Exception;

    /**
     * 根据id修改视频
     * @param video 要修改的视频信息
     * @param  videoDetail  要修改的视频详细信息
     * @return 操作结果
     */
    public  VideoResult updateVideoById(Video video, VideoDetail videoDetail)throws Exception;

}
