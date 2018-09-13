package com.oitsme.admin.fad.pub.dto.publi;

import com.oitsme.admin.fad.common.dto.Request;

import java.io.Serializable;

public class UserLoginRequest  extends Request implements Serializable {


    private static final long serialVersionUID = -1172704107483627831L;
    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append("]");
        return sb.toString();
    }

}