package com.imooc.test.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

/**
 * Created by mike on 2016/8/5.
 */
@Controller
@RequestMapping("/")
public class TestController {

    @RequestMapping("/viewAll")
    public ModelAndView viewAll(String name,String pwd){
        ModelAndView mv=new ModelAndView();
        System.out.println("进入控制器viewAll方法...");
        System.out.println("name="+name);
        System.out.println("password="+pwd);
        mv.setViewName("/hello1.jsp");
        mv.addObject("msg","从ViewAll方法传回视图的数据！");
        return mv;
    }

    @RequestMapping("/query")
    public ModelAndView query(String name,String pwd){
        ModelAndView mv=new ModelAndView();
        System.out.println("进入控制器query方法...");
        System.out.println("name="+name);
        System.out.println("password="+pwd);
        mv.setViewName("hello1.jsp");
        return mv;
    }
}
