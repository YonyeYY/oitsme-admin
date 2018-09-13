package com.oitsme.web.app.controller.dev;


import com.oitsme.admin.fad.common.dto.Response;
import com.oitsme.admin.fad.pub.model.publi.User;
import net.sf.json.JSONObject;
import org.beetl.ext.fn.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import web.common.utils.JsonUtils;
import web.service.publi.UserBiz;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    UserBiz userBiz;

    @RequestMapping("/index")
    public ModelAndView sayHello(){
        ModelAndView modelAndView=new ModelAndView("users","messagePara","This's a messageValue!!!!!!");
        modelAndView.addObject("test", "test value!");


        try{
        User a = userBiz.selectUser(1);
        System.out.println(a.getUserName());
        modelAndView.addObject("user",a.getUserName());
        }
        catch(Exception ex){
            ex.printStackTrace();
            ex.toString();
        }

        return modelAndView;
    }

    @RequestMapping("/json")
    public ModelAndView getjson(@RequestParam("id") int id){
        User user=new User();
        user.setId(id);

        ModelAndView mv=new ModelAndView();
        mv.addObject("user",user);
        mv.setView(new MappingJackson2JsonView());

        return mv;
    }

    @RequestMapping("/showUser")
    public Object showUser() throws Exception {
        Response response=userBiz.selectAllUsers();
        return response.getObject();
    }





}
