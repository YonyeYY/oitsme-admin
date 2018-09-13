package com.oitsme.web.app.controller.dev;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/sys")
public class MainController {

    @RequestMapping("/index")
    public ModelAndView Index(){
        ModelAndView modelAndView =new ModelAndView("main","test","tesst");


        return  modelAndView;

    }
    @RequestMapping("a")
    public void menu(HttpServletRequest request, HttpServletResponse response)throws  Exception{
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}
