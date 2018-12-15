package com.movie.filter;

import com.movie.pojo.User;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        //获取路径
        String uri = request.getRequestURI();
        if(StringUtils.isNoneBlank(uri) && uri.contains("/sub/selectByUser")){
            User user = (User)request.getSession().getAttribute("SysUser");
            //已经登陆的则放行
            if(user != null && StringUtils.isNoneBlank(user.getUserId())){
                filterChain.doFilter(request,response);
            }else {
                request.getSession(false).setAttribute("URI",uri);
                //没登陆则要登陆
                request.getRequestDispatcher("/gopage/user/login").forward(request,response);
            }
        }else {
            filterChain.doFilter(request,response);
        }

    }

    @Override
    public void destroy() {

    }
}
