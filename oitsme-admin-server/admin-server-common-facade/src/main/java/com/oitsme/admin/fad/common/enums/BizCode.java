package com.oitsme.admin.fad.common.enums;


public enum BizCode {

    COMMON_SUCCESS("1000", "操作成功"),
    COMMON_CONFIRM_FAILED("7777", "确认失败"),
    COMMON_ERROR("9000", "操作失败:"),
    COMMON_APPFLOW_NOT_FOUND("9001", "记录不存在"),
    COMMON_DATA_NOFOUND("9002", "数据操作失败-找不到需要处理的记录"),
    COMMON_CANT_REPEAT("9003", "该步骤已操作，不可重复操作"),
    COMMON_GET_PUB_PARA_ERROR("9004", "取系统参数出错"),
    COMMON_REQUEST_ERROR("9100", "请求处理异常"),
    COMMON_RESPONSE_ERROR("9200", "数据处理异常"),
    COMMON_EXCPTION("9998", "操作异常"),
    COMMON_PARAM_ILLEGAL("9999", "传入参数不合法"),
    COMMON_HWNB_REQ_ERROR("9300", "nb接口请求失败"),
    COMMON_PRO_ERROR("9400", "数据库存储过程请求失败"),


    //系统公共方法返回异常
    PUB_SERIOUSNO_ERROR("10001", "获取流水号错误异常"),
    PUB_REFRESHTOKEN_ERROR("10002", "用户uuid校验失败"),
    PUB_OPERATELOG_ERROR("10003", "记录操作日志失败"),
    PUB_GETREFRESHTOKEN_ERROR("10004", "令牌失效，请重新登录"),
    PUB_PARA_ERROR("10005", "参数信息不匹配"),
    PUB_OPENCODE_EXIXTAS("10006","该账户已存在"),
    PUB_USERID_ERROR("10007","用户ID生成失败"),
    PUB_USEROPEN_ERROR("10008","用户注册失败"),
    PUB_USER_NOTEXIXTAS("10009","用户尚未注册"),
    PUB_VERIFCODE_EXPIRED("10010", "验证码已过期"),
    PUB_VERIFCODE_CHECK_EROR("10011", "输入的验证码不正确"),
    PUB_USER_PWD_EROR("10012", "用户名或密码有误"),
    PUB_USER_ICON_EROR("10013", "更新用户头像失败"),
    PUB_USER_INFO_EROR("10014", "修改用户信息失败"),
    PUB_PWD_EROR("10015", "原始密码有误"),
    PUB_USERLEVEL_EROR("10016", "当前用户无权限执行此操作"),



    PUB_1("1","1");

    private String code;
    private String message;

    BizCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static BizCode getBizCodeByCode(String code) {
        for (BizCode bizCode : BizCode.values()) {
            if (bizCode.code.equalsIgnoreCase(code)) {
                return bizCode;
            }
        }
        return null;
    }

    public boolean isSuccess() {
        if (BizCode.COMMON_SUCCESS.getCode().equals(this.code)) {
            return true;
        }
        return false;
    }

    public boolean isError() {
        if (BizCode.COMMON_SUCCESS.getCode().equals(this.code)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "BizCode{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

