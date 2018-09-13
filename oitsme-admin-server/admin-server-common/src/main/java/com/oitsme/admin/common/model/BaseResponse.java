package com.oitsme.admin.common.model;


import com.oitsme.admin.fad.common.enums.BizCode;

/**
 * @Title:BaseResponse
 * @Description:基础返回
 */
public class BaseResponse {
    /**
     * 返回代码
     */
    private String returnCode = BizCode.COMMON_SUCCESS.getCode();
    /**
     * 返回说明
     */
    private String returnMessage;

    public BaseResponse() {
        this.returnCode = BizCode.COMMON_SUCCESS.getCode();
        this.returnMessage = BizCode.COMMON_SUCCESS.getMessage();
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMessage='" + returnMessage + '\'' +
                '}';
    }

    public boolean isSuccee() {
        if (BizCode.COMMON_SUCCESS.getCode().equals(this.returnCode)) {
            return true;
        }
        return false;
    }

    public void setCodeAndMessage(BizCode bizCode) {
        setReturnCode(bizCode.getCode());
        setReturnMessage(bizCode.getMessage());
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
}
