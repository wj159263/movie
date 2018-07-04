package com.movie.mapper;

import com.movie.pojo.VideoDetail;
import com.movie.pojo.VideoDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoDetailMapper {
    int countByExample(VideoDetailExample example);

    int deleteByExample(VideoDetailExample example);

    int insert(VideoDetail record);

    int insertSelective(VideoDetail record);

    List<VideoDetail> selectByExample(VideoDetailExample example);

    int updateByExampleSelective(@Param("record") VideoDetail record, @Param("example") VideoDetailExample example);

    int updateByExample(@Param("record") VideoDetail record, @Param("example") VideoDetailExample example);
}