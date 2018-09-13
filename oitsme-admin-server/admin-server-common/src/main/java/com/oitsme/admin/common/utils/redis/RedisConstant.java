package com.oitsme.admin.common.utils.redis;

/**
 * @Author: pinro
 * @Package_name: com.oitsme.cloud.common.utils.redis
 * @Description:
 * @Date: 2018/4/2 21:31
 * @Moditied:
 */
public class RedisConstant {

    public interface Wechat{
        public static final String WECHATTOKEN = "wechat_token";
    }

    public interface Hw{
        public static final String HWCOMMAND = "hw_command_";
        public static final String HWCOMMANDTIMEFLAG = "hw_command_timeflag_";
        public static final String HWRESETISREL = "hw_resettsrel_";
    }
}
