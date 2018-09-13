package com.oitsme.admin.fad.common.dto;

import com.oitsme.admin.fad.common.enums.BizCode;

import java.io.Serializable;

public class Response implements Serializable {


    private static final long serialVersionUID = 605118392339422003L;
    /**
     * 返回代码
     */
    private String returnCode;
    /**
     * 返回消息
     */
    private String returnMessage;

    private Object object;

    public Response() {
        this.returnCode = BizCode.COMMON_SUCCESS.getCode();
        this.returnMessage = BizCode.COMMON_SUCCESS.getMessage();
    }

    @Override
    public String toString() {
        return "Response{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMessage='" + returnMessage + '\'' +
                ", object=" + object +
                '}';
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public boolean isSuccee() {
        if (BizCode.COMMON_SUCCESS.getCode().equals(this.returnCode)) {
            return true;
        }
        return false;
    }


    public void setCodeAndMessage(String returnCode, String returnMessage) {
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
    }

    public void setCodeAndMessage(BizCode bizCode) {
        this.returnCode = bizCode.getCode();
        this.returnMessage = bizCode.getMessage();
    }

}
