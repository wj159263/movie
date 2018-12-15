package com.movie.controller;

import com.movie.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void loginCheck(HttpServletRequest request, HttpServletResponse response, String account, String password)throws Exception{
        String uri = userService.loginCheck(request, account, password);
        if(StringUtils.isNoneBlank(uri)){
            if(uri.contains("login")){
                uri = "/";
            }
            request.getRequestDispatcher(uri).forward(request, response);
        }else {
            request.getRequestDispatcher("/").forward(request, response);
        }
    }
}
