package com.oitsme.web.app.controller.dev;

import com.oitsme.admin.fad.pub.dto.publi.UserLoginRequest;
import com.oitsme.admin.fad.pub.model.publi.User;
import com.oitsme.admin.fad.pub.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import web.service.publi.UserBiz;


import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserBiz userBiz;

    @RequestMapping("/index")
    public String index(){

        return "login";
    }

    @RequestMapping(value = "/online",method=RequestMethod.POST)
    public ModelAndView login(UserVo userVo,HttpSession session) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        UserLoginRequest request=new UserLoginRequest();


        if(userVo != null && userVo.getUserName()!="" && userVo.getPassword()!=""){
            request.setPassword(userVo.getPassword());
            request.setUserName(userVo.getUserName());


            User activeUser = userBiz.online(request);
            if (activeUser != null) {
                if (activeUser.getPassword().equals(userVo.getPassword())) {
                    // request.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(request, response);
                    //如果Service校验通过，将用户身份记录到Session
                    session.setAttribute("activeUser", activeUser);
                    modelAndView.setViewName("main");
                    modelAndView.addObject("user",activeUser.getUserName());
                    return modelAndView;
                }
            }
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }
@RequestMapping(value = "/logout")
    public ModelAndView logout(HttpSession session) throws Exception{
        //session失效
        session.invalidate();

        ModelAndView modelAndView=new ModelAndView("login");
        return modelAndView;
    }
}
