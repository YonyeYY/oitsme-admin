package com.oitsme.admin.pub.dao.publi;

import com.oitsme.admin.fad.pub.model.publi.User;

import java.util.List;

public interface UserMapper {
    public User findUserById(int id)throws Exception;
    public User findUserByUserName(String name)throws Exception;
    public List<User> selectAllUsers()throws Exception;
}
