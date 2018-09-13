package com.oitsme.admin.fad.pub.dto.publi;

import com.oitsme.admin.fad.pub.model.publi.User;

import java.io.Serializable;

public class UserLoginResponse implements Serializable {


    private static final long serialVersionUID = 8853793659742887292L;
    /**
     * Api使用
     */
    private String token;

    private String refreshToken;

    private User user;

    private String message;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
