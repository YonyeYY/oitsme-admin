package com.oitsme.admin.pub.biz;


import com.oitsme.admin.fad.pub.dto.publi.UserLoginRequest;
import com.oitsme.admin.fad.pub.model.publi.User;
import com.oitsme.admin.pub.dao.publi.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userBiz")
public class UserBiz {
    @Autowired
    UserMapper userMapper;
    public User findUserById(int id) throws Exception {
        User user=userMapper.findUserById(id);
        return user;
    }
    public User findUserByUserName(UserLoginRequest request)throws Exception{

        User user=userMapper.findUserByUserName(request.getUserName());
        System.out.println(request.getUserName()+request.getPassword());

        return user;
    }

    public List<User> selectAllUsers()throws Exception{
        List<User> list=userMapper.selectAllUsers();
        return list;
    }


}
