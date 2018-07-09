package com.movie.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 图片上传
 */
public interface FileUploadService {

    public Map uploadPic(MultipartFile uploadFile) throws Exception;
}
