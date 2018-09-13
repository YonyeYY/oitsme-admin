package com.oitsme.admin.fad.pub.facade.dev;


import com.oitsme.admin.fad.common.dto.Response;
import com.oitsme.admin.fad.pub.dto.publi.UserLoginRequest;
import com.oitsme.admin.fad.pub.model.publi.User;

import java.util.List;

public interface IUserAPI {
    public User processFindUserById(int id)throws  Exception;
    public User processFindUserByUserName(UserLoginRequest request)throws Exception;
    public Response processSelectAllUsers()throws Exception;
}
