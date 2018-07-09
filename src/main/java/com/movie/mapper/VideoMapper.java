package com.movie.mapper;

import com.movie.dto.EyUIGridResult;
import com.movie.pojo.Video;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoMapper {
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
   * 分页查询多条视频
   * @param start 开始记录
   * @param rows 查询的记录数
   * @return
   */
  public List<Video> selectVideoList(@Param("start") int start, @Param("rows") int rows, @Param("name") String name);

  /**
   * 条件查询的视频的数量
   * @return
   */
  public long selectVideoCount(@Param("name") String name);

  /**
   * 查询的视频的总数量
   * @return
   */
  public long selectVideoTotalCount();

    /**
     * 添加视频
     * @param video 视频信息
     * @return  数据库影响行数
     */
  public  int insertVideo(Video video);

    /**
     * 根据id删除视频
     * @param id 视频id
     * @return 数据库影响行数
     */
  public int deleteVideoById(String id);

    /**
     * 根据id修改视频
     * @param video 要修改的视频信息
     * @return 数据库影响行数
     */
  public  int updateVideoById(Video video);

}