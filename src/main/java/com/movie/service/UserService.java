package com.movie.service;

import com.movie.pojo.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    /**
     * 登陆认证
     * @param account 账号
     * @param password 密码
     * @return
     */
    public String loginCheck(HttpServletRequest request, String account, String password);
}
