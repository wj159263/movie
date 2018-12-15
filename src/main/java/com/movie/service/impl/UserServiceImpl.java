package com.movie.service.impl;

import com.movie.mapper.UserMapper;
import com.movie.pojo.User;
import com.movie.pojo.UserExample;
import com.movie.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private  static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Override
    public String loginCheck(HttpServletRequest request, String account, String password) {
        String returnURI = null;
        UserExample example = new UserExample();
        example.createCriteria().andAccountEqualTo(account);
        //根据账号查出用户
        List<User> list= userMapper.selectByExample(example);
        //查出了用户并且不为空时，对比md5加密后的密码
        if(list != null && list.size()>0 && StringUtils.isNoneBlank(password)){
            User user = list.get(0);
            if(DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getParrword())){
                System.out.println("密码匹配成功");
                request.getSession().setAttribute("SysUser",user);
                returnURI = (String)request.getSession(false).getAttribute("URI");
                System.out.println(user.getNickName()+"登陆了系统，时间："+ new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(new Date()));
                LOGGER.info(user.getNickName()+"登陆了系统，时间："+ new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(new Date()));
            }else {
                System.out.println("密码匹配失败");
                //密码不匹配时
                returnURI = "/gopage/user/login";
            }
        }else {
            //账号不存在或密码不填写时
            returnURI = "/gopage/user/login";
        }
        return returnURI;
    }


}
