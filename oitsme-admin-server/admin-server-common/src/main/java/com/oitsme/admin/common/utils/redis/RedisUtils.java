package com.oitsme.admin.common.utils.redis;

import com.alibaba.fastjson.JSONObject;
import com.oitsme.admin.common.context.SpringContextUtil;
import com.oitsme.admin.common.utils.DateUtils;
import com.oitsme.admin.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 *
 * @Description:redis通用的的帮助类，需要spring 容器支持
 */
public class RedisUtils {
    protected static final Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    private static RedisTemplate jedisTemplate = (RedisTemplate) SpringContextUtil.getBean("jedisTemplate");

    public static <T> T get(String key, Class<T> clazz) {
        try {
            ValueOperations<String, T> ops = jedisTemplate.opsForValue();
            T value = ops.get(key);
            return value;
        } catch (Exception e) {
            logger.info("get from Cache error! key = {" + key + "}", e);
            logger.warn("catch error!", e);
            return null;
        }
    }

    public static Set getSet(String key) {
        try {
            SetOperations ops = jedisTemplate.opsForSet();
            return ops.members(key);
        } catch (Exception e) {
            logger.info("get from Cache error! key = {" + key + "}", e);
            logger.warn("catch error!", e);
            return null;
        }
    }

    public static String getString(String key) {
        return get(key, String.class);
    }

    public static Integer getInteger(String key) {
        return get(key, Integer.class);
    }

    public static <T> boolean set(String key, T value, int expire) {
        try {
            if (value == null) {
                return Boolean.FALSE;
            }
            ValueOperations<String, T> ops = jedisTemplate.opsForValue();
            ops.set(key, value);
            return jedisTemplate.expire(key, expire, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.info("set to Cache error! key = {" + key + "}", e);
            logger.warn("set to Cache error!", e);
        }
        return Boolean.FALSE;
    }

    public static boolean setString(String key, String value, int expire) {
        return set(key, value, expire);
    }

    public static boolean setString(String key, String value) {
        try {
            if (value == null) {
                return Boolean.FALSE;
            }
            ValueOperations<String, String> ops = jedisTemplate.opsForValue();
            ops.set(key, value);
        } catch (Exception e) {
            logger.info("set to Cache error! key = {" + key + "}", e);
            logger.warn("set to Cache error!", e);
        }
        return Boolean.FALSE;
    }

    public static <T> boolean set(String key, T value) {
        try {
            if (value == null) {
                return Boolean.FALSE;
            }
            ValueOperations<String, T> ops = jedisTemplate.opsForValue();
            ops.set(key, value);
        } catch (Exception e) {
            logger.info("set to Cache error! key = {" + key + "}", e);
            logger.warn("set to Cache error!", e);
        }
        return Boolean.FALSE;
    }

    public static boolean setDefExpire(String key, String value) {
        return set(key, value, 5 * 60 * 1000);
    }

    public static <T> boolean setDefExpire(String key, T value) {
        return set(key, value, 5 * 60 * 1000);
    }

    public static void del(String key) {
        try {
            jedisTemplate.delete(key);
        } catch (Exception e) {
            logger.info("delete from Cache error! key = {" + key + "}", e);
            logger.warn("delete from Cache error!", e);
        }
    }

    public static void refExpire(String key, long time){
        try {
            if (time > 0) {
                jedisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            logger.info("refresh expire error! key = {" + key + "}", e);
            logger.warn("refresh expire error!", e);
        }
    }

    /**
     * key是否存在
     *
     * @param key
     */
    public static boolean exists(final String key) {
        return jedisTemplate.hasKey(key);
    }

    /**
     * 把lis放入redis缓存起来,当天
     *
     * @param cacheKey
     * @param list
     */
    public static void putListByRedisCache2ToDay(String cacheKey, List list) {
        putListByRedisCache(cacheKey, list, DateUtils.getMilliSecondsLeftToday());
    }

    /**
     * 把lis放入redis缓存起来,一个小时
     *
     * @param cacheKey
     * @param list
     */
    public static void putListByRedisCache2ToOneHours(String cacheKey, List list) {
        putListByRedisCache(cacheKey, list, 2 * 60 * 60 * 1000);
    }

    /**
     * 把lis放入redis缓存起来,30分钟
     *
     * @param cacheKey
     * @param list
     */
    public static void putListByRedisCache2To30Min(String cacheKey, List list) {
        putListByRedisCache(cacheKey, list, 30 * 60 * 1000);
    }

    /**
     * 把map放入redis缓存起来,当天
     *
     * @param cacheKey
     * @param map
     */
    public static Long putHashMap(String cacheKey, Map map, long time) {
        try {
            jedisTemplate.opsForHash().putAll(cacheKey, map);
            if (time > 0) {
                jedisTemplate.expire(cacheKey, time, TimeUnit.SECONDS);
            }
            return jedisTemplate.opsForHash().size(cacheKey);
        } catch (Exception e) {
            logger.error("putHashMap,cacheKey[" + cacheKey + "]", e);
        }
        return 0l;
    }

    /**
     * 向key对应的map中添加缓存对象
     *
     * @param cacheKey cache对象key
     * @param field    map对应的key
     * @param value    值
     */
    public static void addMap(String cacheKey, String field, Object value) {
        jedisTemplate.opsForHash().put(cacheKey, field, value);
    }

    /**
     * 把map放入redis缓存起来,当天
     *
     * @param cacheKey
     */
    public static Map getAllHashMap(String cacheKey) {
        BoundHashOperations boundHashOperations = jedisTemplate.boundHashOps(cacheKey);
        return boundHashOperations.entries();
    }

    /**
     * 把map放入redis缓存起来,当天
     *
     * @param cacheKey
     */
    public static Object getMapField(String cacheKey, String field) {
        return jedisTemplate.boundHashOps(cacheKey).get(field);
    }

    /**
     * 删除map中的某个对象
     *
     * @param key   map对应的key
     * @param field map中该对象的key
     * @author pinro
     */
    public static void delMapField(String key, String... field) {
        BoundHashOperations<String, String, ?> boundHashOperations = jedisTemplate.boundHashOps(key);
        boundHashOperations.delete(field);
    }

    public static void putListByRedisCache(String cacheKey, List list, long time) {
        try {
            Set set = jedisTemplate.opsForSet().members(cacheKey);
            if (!set.isEmpty()) {// 如果当天数据已经存在redis中则不进行更新
                return;
            }
            SetOperations operations = jedisTemplate.opsForSet();
            int size = 0;
            for (int i = 0; i < list.size(); i++) {
                size += operations.add(cacheKey, list.get(i));
            }
            // 放入缓存的时间 毫秒
            jedisTemplate.expire(cacheKey, time, TimeUnit.MILLISECONDS);

            if (size == list.size()) {
                logger.info("[" + cacheKey + "]缓存成功,size:" + size);
            } else {
                logger.info("[" + cacheKey + "]缓存失败,size:" + size);
                logger.error("[" + cacheKey + "]缓存失败,size:" + size);
            }

        } catch (Exception e) {
            logger.error("[" + cacheKey + "]缓存失败,List:" + JSONObject.toJSONString(list));
        }

    }

    public static boolean hasKey(String pubparadescmap, String key) {
        try {
            return jedisTemplate.boundHashOps(pubparadescmap).hasKey(key);
        } catch (Exception e) {
            logger.error("hasKey[" + key + "]hasKey,List:", e);
        }

        return false;
    }


    /**
     * pub 、sub 模式
     * @param channel
     * @param message
     * @return
     */
    public static boolean pubMessage(String channel, Object message) {

        try {
            jedisTemplate.convertAndSend(channel, message);
        } catch (Exception e) {
            logger.error("pubMessage,channel=" + channel + ",message=" + StringUtils.toJson(message) + " ", e);
            return false;
        }

        return true;
    }
}
