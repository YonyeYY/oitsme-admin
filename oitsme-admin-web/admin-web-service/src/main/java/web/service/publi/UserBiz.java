package web.service.publi;


import com.oitsme.admin.fad.common.dto.Response;
import com.oitsme.admin.fad.pub.dto.publi.UserLoginRequest;
import com.oitsme.admin.fad.pub.facade.dev.IUserAPI;
import com.oitsme.admin.fad.pub.model.publi.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("userBiz")
public class UserBiz {

    @Autowired
    IUserAPI iUserAPI;

    public User selectUser(int id)throws Exception{
        User user;
        user =iUserAPI.processFindUserById(id);
        return  user;
    }
    public User online(UserLoginRequest request)throws  Exception{
        User user=iUserAPI.processFindUserByUserName(request);


        return user;
    }
    public Response selectAllUsers()throws  Exception{
        Response response=iUserAPI.processSelectAllUsers();

        return response;
    }



}
