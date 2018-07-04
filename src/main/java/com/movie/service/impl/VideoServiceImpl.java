package com.movie.service.impl;

import com.movie.mapper.VideoDetailMapper;
import com.movie.mapper.VideoMapper;
import com.movie.pojo.Video;
import com.movie.pojo.VideoDetail;
import com.movie.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private VideoDetailMapper videoDetailMapper;

    @Override
    public Video selectVideoById(String id) {
        return videoMapper.selectVideoById(id);
    }

    @Override
    public Video selectVideoByIdWithBlobs(String id) {
        return videoMapper.selectVideoByIdWithBlobs(id);
    }

    @Override
    public int insertVideo(Video video, VideoDetail videoDetail) {
        return videoMapper.insertVideo(video);
    }

    @Override
    public int deleteVideoById(String id) {
        return videoMapper.deleteVideoById(id);
    }

    @Override
    public int updateVideoById(Video video, VideoDetail videoDetail) {
        return videoMapper.updateVideoById(video);
    }
}
