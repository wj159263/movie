package com.movie.mapper;

import com.movie.dto.EyuiDatagridLoop;
import com.movie.pojo.CenterLoop;
import com.movie.pojo.CenterLoopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CenterLoopMapper {
    int countByExample(CenterLoopExample example);

    int deleteByExample(CenterLoopExample example);

    int insert(CenterLoop record);

    List<EyuiDatagridLoop> selectList(@Param("start") int start, @Param("rows") int rows);

    int insertSelective(CenterLoop record);

    List<CenterLoop> selectByExample(CenterLoopExample example);

    int updateByExampleSelective(@Param("record") CenterLoop record, @Param("example") CenterLoopExample example);

    int updateByExample(@Param("record") CenterLoop record, @Param("example") CenterLoopExample example);
}