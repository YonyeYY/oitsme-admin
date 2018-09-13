package com.oitsme.admin.common.utils.redis;

import com.oitsme.admin.common.constant.CacheConstant;
import com.oitsme.admin.common.context.SpringContextUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * @Description:pubParaDesc表的帮助类（翻译表），需要spring 容器支持
 */
public class PubParaDescConstant {

	protected static final Log log = LogFactory.getLog(PubParaDescConstant.class);

	private static RedisTemplate jedisTemplate = (RedisTemplate) SpringContextUtil.getBean("jedisTemplate");

	public static Map getPubParaDescList(String sysNo, String paraKey) {
		long startTime = System.currentTimeMillis();
		String key = sysNo + "|" + paraKey;
		log.debug("getPubParaDescList(" + sysNo + "," + paraKey + ")");
		if (RedisUtils.hasKey(CacheConstant.Forever.PUBPARADESCMAP, key)) {
			Map hashCache = (Map) RedisUtils.getMapField(CacheConstant.Forever.PUBPARADESCMAP, key);
			long endTime = System.currentTimeMillis();
			log.info("******************************************************************************************");
			log.info("JSON.parseArray(hashCache.toString(), PubParaDesc.class);[" + (endTime - startTime) + "]");
			return hashCache;
		}
		return new HashMap();
	}

	public static String getPubParaDesc(String sysNo, String paraKey, String paraValue) {

		String key = sysNo + "|" + paraKey + "|" + paraValue;

		if (RedisUtils.hasKey(CacheConstant.Forever.PUBPARADESCMAP, key)) {
			String hashCache = (String) RedisUtils.getMapField(CacheConstant.Forever.PUBPARADESCMAP, key);
			return hashCache;
		}

		return "";
	}

	public interface SysNo {
		public static final String DEV = "DEV";
		public static final String KEY = "KEY";
		public static final String PUB = "PUB";
	}

	public interface ParaKey {
		public static final String OPERATETYPE = "OPERATETYPE";
		public static final String TYPE = "TYPE";
		public static final String LOCKTYPE = "LOCKTYPE";
		public static final String BOOLEAN = "BOOLEAN";
		public static final String INSTALLTYPE = "INSTALLTYPE";
		public static final String SHAREKEYTYPE = "SHAREKEYTYPE";
		public static final String STATUS = "STATUS";
		public static final String TIMEZONE = "TIMEZONE";
	}
}
