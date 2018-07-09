package com.movie.service.impl;

import com.movie.service.FileUploadService;
import com.movie.util.FtpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Value("${FTP_ADDRESS}")
    private String FTP_ADDRESS;
    @Value("${FTP_PORT}")
    private Integer FTP_PORT;
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_BASE_PATH}")
    private String FTP_BASE_PATH;
    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;

    @Override
    public Map uploadPic(MultipartFile uploadFile) throws Exception {
        HashMap hashMap = new HashMap<>();

        //获取图片原本的名字
        String oldName = uploadFile.getOriginalFilename();
        //获取图片原本的尾缀
        String font = oldName.substring(oldName.lastIndexOf("."));
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        //文件路径，格式为  "video/2018/10/20"
        String pathName ="video/"+ calendar.get(Calendar.YEAR) + "/" + month + "/" + calendar.get(Calendar.DAY_OF_MONTH);
        String newName = calendar.getTimeInMillis() + (new Random().nextInt(999)) + font;

        boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD,
                FTP_BASE_PATH, pathName , newName, uploadFile.getInputStream());

        //result为false则表示上传失败,map封装的key是kingEditor要求的格式
        if (! result) {
            hashMap.put("error", 1);
            hashMap.put("message", "文件上传失败");
            return hashMap;
        }
        hashMap.put("error", 0);
        hashMap.put("url", IMAGE_BASE_URL +"/"+ pathName + "/" + newName);
        return hashMap;
    }
}
