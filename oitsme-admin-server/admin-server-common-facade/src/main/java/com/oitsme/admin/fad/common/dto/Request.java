package com.oitsme.admin.fad.common.dto;

import java.io.Serializable;

public class Request  implements Serializable {
    private static final long serialVersionUID = 5146722504188438467L;

    /**
     * 请求方IP
     */
    private String clientIpAddress;
    /**
     * 网点代码
     */
    private String netNo;
    /**
     * 操作员代码
     */
    private String operatorNo;
    /**
     * 操作类型
     */
    private String operateType;
    /**
     * 交易日期
     */
    private String tradeDate;
    /**
     * 请求报文流水号
     */
    private String seriousNo;
    /**
     * 接单时间
     */
    private String acceptTime;
    /**
     * 接单日期
     */
    private String inputDate;
    /**
     * 微信公众号id
     */
    private String appId;
    /**
     * 微信公众号密码
     */
    private String appSecret;
    /**
     * 微信公众号获取token地址
     */
    private String accessTokenUrl;

    @Override
    public String toString() {
        return "Request{" + "clientIpAddress='" + clientIpAddress + '\'' + ", netNo='" + netNo + '\'' + ", operatorNo='" + operatorNo + '\'' + ", tradeDate='" + tradeDate + '\'' + ", seriousNo='" + seriousNo + '\'' + ", acceptTime='" + acceptTime + '\'' + ", inputDate='" + inputDate + '\'' + ", appId='" + appId + '\'' + ", appSecret='" + appSecret + '\'' + ", accessTokenUrl='" + accessTokenUrl + '\'' + '}';
    }


    public String getClientIpAddress() {
        return clientIpAddress;
    }

    public void setClientIpAddress(String clientIpAddress) {
        this.clientIpAddress = clientIpAddress;
    }

    public String getNetNo() {
        return netNo;
    }

    public void setNetNo(String netNo) {
        this.netNo = netNo;
    }

    public String getOperatorNo() {
        return operatorNo;
    }

    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getSeriousNo() {
        return seriousNo;
    }

    public void setSeriousNo(String seriousNo) {
        this.seriousNo = seriousNo;
    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAccessTokenUrl() {
        return accessTokenUrl;
    }

    public void setAccessTokenUrl(String accessTokenUrl) {
        this.accessTokenUrl = accessTokenUrl;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }
}
