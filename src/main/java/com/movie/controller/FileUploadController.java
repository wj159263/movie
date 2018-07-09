package com.movie.controller;

import com.movie.service.FileUploadService;
import com.movie.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public String pictureUpload(MultipartFile uploadFile) throws Exception {
        Map result = fileUploadService.uploadPic(uploadFile);
        //为了保证功能的兼容性，需要把Result转换成json格式的字符串。
        String json = JsonUtils.objectToJson(result);
        return json;
    }
}
