package com.xs.java.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginInterceptor implements HandlerInterceptor {

    private String[] authurl = {"manager"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String url = request.getRequestURL().toString();
        for(String oneAuthUrl : authurl){
            if(!url.contains(oneAuthUrl)){
                return true;
            }
        }

        //获取session
        HttpSession session = request.getSession();

        //判断用户ID是否存在，不存在就跳转到登录界面
        if(session.getAttribute("user") == null || !(boolean)session.getAttribute("user")){
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }else{
            return true;
        }
    }

}
