package com.oitsme.admin.pub.facade.dev;

import com.oitsme.admin.fad.pub.facade.dev.IOutPutAPI;
import com.oitsme.admin.fad.pub.facade.dev.IUserAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("iOutPutAPI")
public class IOutPutImpl implements IOutPutAPI {

    @Autowired
    IUserAPI iUserAPI;




    @Override
    public void outPut()throws  Exception{
        System.out.println("outPut!!!!!!");
        iUserAPI.processFindUserById(1).toString();

    }
}
