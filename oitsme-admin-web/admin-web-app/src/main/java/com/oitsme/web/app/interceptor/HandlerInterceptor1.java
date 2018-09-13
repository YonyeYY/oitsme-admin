package com.oitsme.web.app.interceptor;

import com.oitsme.admin.fad.pub.model.publi.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class HandlerInterceptor1 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {



       //判断用户身份在Session中是否存在
      HttpSession session = request.getSession();
       User activeUser = (User) session.getAttribute("activeUser");
       //如果用户身份在session中存在则放行
       if (activeUser!=null) {
           return true;
       }
       //执行到这里拦截，跳转到登录页面，用户进行身份认证
//    //    request.getRequestDispatcher("").forward(request, response);


           request.getRequestDispatcher("../WEB-INF/jsp/login.jsp").forward(request, response);




        //如果返回false表示拦截器不继续执行handler，如果返回true表示放行
        return false;



    }

    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
