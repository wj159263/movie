package com.movie.service.impl;

import com.movie.dto.EyUIGridResult;
import com.movie.dto.VideoPortalDto;
import com.movie.dto.VideoResult;
import com.movie.enums.VideoEnum;
import com.movie.exception.CanNotPlayException;
import com.movie.exception.NoDataException;
import com.movie.exception.SystemException;
import com.movie.mapper.VideoDetailMapper;
import com.movie.mapper.VideoMapper;
import com.movie.pojo.Video;
import com.movie.pojo.VideoDetail;
import com.movie.pojo.VideoDetailExample;
import com.movie.service.VideoService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class VideoServiceImpl implements VideoService {

    public static final Logger LOGGER = LoggerFactory.getLogger(VideoServiceImpl.class);

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private VideoDetailMapper videoDetailMapper;

    @Override
    public Video selectVideoById(String id) throws SystemException, NoDataException, CanNotPlayException {
        try {
            Video video = videoMapper.selectVideoById(id);
            if (video == null) {
                throw new NoDataException("资源不存在!");
            } else if (video.getState() == 0) {
                throw new CanNotPlayException("视频无法播放!");
            } else {
                return video;
            }
        } catch (SystemException e1) {
            throw e1;
        } catch (NoDataException e2) {
            throw e2;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public VideoResult deleteVideoById(String id) throws Exception {
        int rows = videoMapper.deleteVideoById(id);
        //影响行数小于1，则不成功
        if (rows < 1) {
            throw new Exception();
        }
        return VideoResult.build(VideoEnum.SUCCESS, null);
    }

    @Override
    public List<VideoPortalDto> selectVideosSimple() throws SystemException, NoDataException {
        try {
            List<Map> returnVal = videoMapper.selectVideosSimple();
            if (returnVal != null && returnVal.size() > 0) {
                List<VideoPortalDto> result = this.listToDto(returnVal, 6);
                return result;
            } else {
                throw new NoDataException("资源不存在!");
            }
        } catch (SystemException e1) {
            throw e1;
        } catch (NoDataException e2) {
            throw e2;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

    /**
     * 组装数据成以下格式
     * {"cName":"战争",
     * "dataList":[{"videoName":"战争之王","image":"1.png"},{"videoName":"战争之王2","image":"2.png"}]
     * }
     *
     * @return
     */
    public List<VideoPortalDto> listToDto(List<Map> dataMap, Integer num) {
        List<VideoPortalDto> result = new LinkedList<VideoPortalDto>();
        Set<String> set = new HashSet<String>();
        //先获取所有查询的视频分类
        if (dataMap.size() > 0 && dataMap != null) {
            for (Map map : dataMap) {
                set.add((String) map.get("cName"));
            }
        }
        //遍历视频分类，组装数据
        for (String tempCName : set) {
            if (StringUtils.isNoneBlank(tempCName)) {
                VideoPortalDto dto = new VideoPortalDto();
                dto.setcName(tempCName);
                List list = new LinkedList<>();
                Integer x = 0;
                for (Map map : dataMap) {
                    //截取长度
                    if (x >= num && num != null) {
                        break;
                    }
                    //如果分类相同，则添加到同一集合中
                    if (tempCName.equals((String) map.get("cName"))) {
                        list.add(map);
                        x++;
                    }
                }
                dto.setDataList(list);
                result.add(dto);
            }
        }
        return result;
    }

    @Override
    public Video selectVideoByIdWithBlobs(String id) {
        return videoMapper.selectVideoByIdWithBlobs(id);
    }

    @Override
    public EyUIGridResult selectVideoList(int page, int rows, String name) throws Exception {
        if (page < 1) {
            page = 1;
        }
        //开始记录数
        int start = (page - 1) * rows;
        List<Video> videoList = videoMapper.selectVideoList(start, rows, name);
        //视频总数
        long count = videoMapper.selectVideoCount(name);
        //组装成easyui需要的格式数据
        EyUIGridResult gridResult = new EyUIGridResult();
        gridResult.setRows(videoList);
        gridResult.setTotal(count);
        return gridResult;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public VideoResult insertVideo(Video video, VideoDetail videoDetail) throws Exception {
        String id = UUID.randomUUID().toString().replace("-", "");
        video.setVideoId(id);
        videoDetail.setVideoId(id);
        videoDetail.setUpdated(new Date());
        videoDetail.setUptime(new Date());
        int rows = videoMapper.insertVideo(video);
        //影响行数小于1，则不成功
        if (rows < 1) {
            throw new Exception();
        }
        rows = videoDetailMapper.insert(videoDetail);
        if (rows < 1) {
            throw new Exception();
        }
        return VideoResult.build(VideoEnum.SUCCESS, null);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public VideoResult deletebachByIds(String[] ids) throws Exception {
        if (ids.length > 0) {
            //遍历数组删除
            for (int index = 0; index < ids.length; index++) {
                int rows = videoMapper.deleteVideoById(ids[index]);
                //数据库影响行数小于1则抛出异常
                if (rows < 1) {
                    throw new Exception();
                }
                //删除videoDetail的数据
                VideoDetailExample example = new VideoDetailExample();
                example.createCriteria().andVideoIdEqualTo(ids[index]);
                rows = videoDetailMapper.deleteByExample(example);
                //数据库影响行数小于1则抛出异常
                if (rows < 1) {
                    throw new Exception();
                }
            }
        }
        return VideoResult.build(VideoEnum.SUCCESS, ids.length);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public VideoResult updateVideoById(Video video, VideoDetail videoDetail) throws Exception {
        int rows = videoMapper.updateVideoById(video);
        //影响行数小于1，则不成功
        if (rows < 1) {
            throw new Exception();
        }
        return VideoResult.build(VideoEnum.SUCCESS, null);
    }


    @Override
    public List<Video> selectByName(String videoName) throws SystemException, NoDataException {
        try {
            List<Video> list = videoMapper.selectByName(videoName);
            if (list == null && list.size() < 1) {
                throw new NoDataException("资源不存在！");
            }
            return list;
        } catch (NoDataException e1) {
            LOGGER.error(e1.getMessage());
            throw e1;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new SystemException(e.getMessage());
        }

    }
}
