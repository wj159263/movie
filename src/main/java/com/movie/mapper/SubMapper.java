package com.movie.mapper;

import com.movie.pojo.Sub;
import com.movie.pojo.SubExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubMapper {
    int countByExample(SubExample example);

    int deleteByExample(SubExample example);

    int insert(Sub record);

    int insertSelective(Sub record);

    List<Sub> selectByExample(SubExample example);

    int updateByExampleSelective(@Param("record") Sub record, @Param("example") SubExample example);

    int updateByExample(@Param("record") Sub record, @Param("example") SubExample example);
}