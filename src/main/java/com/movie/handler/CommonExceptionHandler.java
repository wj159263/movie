package com.movie.handler;

import com.movie.exception.CanNotPlayException;
import com.movie.exception.NoDataException;
import com.movie.exception.SystemException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 全局异常处理类
 */
public class CommonExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        e.printStackTrace();
        if(e instanceof SystemException){
            try {
                response.sendRedirect("/gopage/error/systemException");
            }catch (IOException e1){
                e1.printStackTrace();
            }
        }else if(e instanceof NoDataException){
            try {
                response.sendRedirect("/gopage/error/noDataException");
            }catch (IOException e1){
                e1.printStackTrace();
            }
        }else if(e instanceof CanNotPlayException){
            try {
                response.sendRedirect("/gopage/error/canNotPlayException");
            }catch (IOException e1){
                e1.printStackTrace();
            }
        }

        return new ModelAndView();
    }
}
