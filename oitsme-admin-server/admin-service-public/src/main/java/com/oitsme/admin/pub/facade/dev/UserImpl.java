package com.oitsme.admin.pub.facade.dev;


import com.oitsme.admin.fad.common.dto.Response;
import com.oitsme.admin.fad.pub.dto.publi.UserLoginRequest;
import com.oitsme.admin.fad.pub.facade.dev.IUserAPI;
import com.oitsme.admin.fad.pub.model.publi.User;
import com.oitsme.admin.pub.biz.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("iUserAPI")
public class UserImpl implements IUserAPI {
    @Autowired
    UserBiz userBiz;



    @Override
    public User processFindUserById(int id) throws  Exception{
       User user= userBiz.findUserById(id);
       return user;
    }

    @Override
    public User processFindUserByUserName(UserLoginRequest request) throws Exception {

        User user = userBiz.findUserByUserName(request);

        return user;
    }

    @Override
    public Response processSelectAllUsers() throws Exception {
        List<User> list= userBiz.selectAllUsers();
        Response response=new Response();
        response.setObject(list);
        return response;
    }
}
