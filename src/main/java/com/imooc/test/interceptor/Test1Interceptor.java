package com.imooc.test.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 编写拦截器类实现HandlerInterceptor接口
 * Created by mike on 2016/8/5.
 */
public class Test1Interceptor implements HandlerInterceptor {
    /**
     * 当用户没有登录的时候终止请求
     * 返回值：是否将当前的请求拦截下来
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return 如果返回false，请求将被终止，如果返回为true，请求继续运行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        System.out.println("执行到了preHandle方法");

        //对用户登录进行判断
        if (httpServletRequest.getSession().getAttribute("user")==null){
            httpServletRequest.getRequestDispatcher("login.jsp").forward(httpServletRequest,httpServletResponse);
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("执行到了postHandle方法");
        //可以通过ModelAndView参数来改变显示的视图
        //或修改发往视图的方法
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("执行到了afterCompletion方法");
    }
}
