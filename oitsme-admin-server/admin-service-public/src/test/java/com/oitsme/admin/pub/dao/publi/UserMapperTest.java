package com.oitsme.admin.pub.dao.publi;

import com.oitsme.admin.fad.pub.facade.dev.IOutPutAPI;
import com.oitsme.admin.fad.pub.facade.dev.IUserAPI;
import com.oitsme.admin.fad.pub.model.publi.User;
import com.oitsme.admin.pub.facade.dev.IOutPutImpl;
import com.oitsme.admin.pub.facade.dev.UserImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class UserMapperTest {
    private ApplicationContext applicationContent;

    IOutPutAPI iOutPutAPI;




    //在setUp这个方法构造（得到spring容器）
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testFindUserById() throws Exception {
        //	try{
        //     User qwe=userImpl.processFindUserById(1);
        //  System.out.println(qwe.toString());
        applicationContent = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");

        iOutPutAPI = applicationContent.getBean("iOutPutAPI",IOutPutImpl.class);
        iOutPutAPI.outPut();


//        iUserAPI=applicationContent.getBean("ui", UserImpl.class);
//        User user22 = iUserAPI.processFindUserById(1);
//        System.out.println(user22.getUserName());
//
//        System.out.println(user22.toString());
//        UserMapper userMapper = (UserMapper) applicationContent.getBean("userMapper");
//        User user = userMapper.findUserById(1);
//        System.out.println(user.toString());
//        System.out.println(user.getUserName());
//

        //	}catch (Exception e) {
        // TODO: handle exception
        //		e.toString();
        //		System.out.println("end");
        //	}


    }

}