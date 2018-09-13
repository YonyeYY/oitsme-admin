package com.oitsme.admin.common.constant;

/**
 * 缓存常量类
 */
public class CacheConstant {
    /**
     * 图形验证码
     **/
    public static final String IMG_CODE = "IMG_CODE_";
    /**
     * 手机验证码
     **/
    public static final String SMS_VERIFY = "SMS_VERIFY_";
    /**
     * 手机验证码每天的次数
     **/
    public static final String SMS_VERIFY_COUNT = "SMS_VERIFY_COUNT_";
    /**
     * 华为nbtoken
     **/
    public static final String NB_TOKEN = "NB_TOKEN_";
    public static final String NB_BEARER_TOKEN = "BEARER";
    /**
     * 华为nbrefreshtoken
     **/
    public static final String NB_REFRESHTOKEN = "NB_REFRESHTOKENTOKEN_";
    /**
     * 需要一直缓存的key
     */
    public interface Forever {
        /**y
        /**
         * 翻译表缓存的key
         */
        String PUBPARADESCMAP = "pubParaDescMap";
        String PUBPARADESCMAP_INIT = "pubParaDescMapInit";
        /**
         * 参数表缓存
         */
        String PUBPARA_MAP_INIT = "pubParaMapInit";


    }

}
