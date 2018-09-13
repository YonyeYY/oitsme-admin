package com.oitsme.admin.common.model;


/**
 * @Title:ProBaseResponse
 * @Description:调用存储过程基础返回
 */
public class ProBaseResponse {
    /**
     * 返回代码
     */
    private String returncode;
    /**
     * 返回说明
     */
    private String returnmessge;

    public String getReturncode() {
        return returncode;
    }

    public void setReturncode(String returncode) {
        this.returncode = returncode;
    }

    public String getReturnmessge() {
        return returnmessge;
    }

    public void setReturnmessge(String returnmessge) {
        this.returnmessge = returnmessge;
    }
}
