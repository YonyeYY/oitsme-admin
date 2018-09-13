package com.oitsme.admin.common.context;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.fastjson.JSONObject;
import com.oitsme.admin.fad.common.dto.Request;
import com.oitsme.admin.fad.common.dto.Response;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: pinro
 * @Package_name:
 * @Description: 业务日志监控
 * @Date:
 * @Moditied:
 */

@Aspect
@Component
public class DubboInterceptor {
    private static final Logger logger = Logger.getLogger(DubboInterceptor.class);
    private static final Logger errorlogger = Logger.getLogger(Throwable.class);

    @Pointcut("execution (* com.oitsme.cloud.*.facade.*..*Impl.*(..))")
    public void controllerAspect() {
        logger.info("用于拦截Controller层记录用户的操作");
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    //  @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("用于拦截Controller层记录用户的操作" + joinPoint.toShortString());
    }

    //配置controller环绕通知,使用在方法aspect()上注册的切入点
    @Around("controllerAspect()")
    public Object around(JoinPoint joinPoint) throws Throwable {
        long startTime1 = System.currentTimeMillis();
        Request request = null;
        Response response = null;
        String uuid = RpcContext.getContext().getAttachment("req.id");
      //  MDC.put("req.id", StringUtils.isEmpty(uuid) ? UUID.randomUUID().toString().replaceAll("-", "") : uuid);

        Object returnObj = null;

        Object[] args = joinPoint.getArgs();
        for (Object obj : args) {
            if (obj instanceof Request) {
                request = (Request) obj;
                break;
            }
        }

        long startTime = System.currentTimeMillis();

        try {
            returnObj = ((ProceedingJoinPoint) joinPoint).proceed();

            if (returnObj instanceof Response) {
                response = (Response) returnObj;
            }
            writeLog(request, response, startTime, joinPoint);
        } catch (Throwable throwable) {
            errorlogger.error(joinPoint.toShortString() + "error ::: ", throwable);
            throw throwable;
        } finally {
            RpcContext.getContext().setAttachment("req.id", uuid);
           long time= (System.currentTimeMillis() - startTime1);
            logger.error("DubboInterceptor  time:"+time);
        }

        return returnObj;
    }

    /**
     * 记录日志  接口 客户Id 入参 出参数 耗时
     *
     * @param request
     * @param response
     * @param startTime
     * @param joinPoint
     */
    private void writeLog(Request request, Response response, long startTime, JoinPoint joinPoint) throws IOException {
        MonitorReq log = new MonitorReq();

        String className = joinPoint.toShortString();
        log.setClassName(className.substring(className.indexOf("("), className.lastIndexOf("(")));
        log.setTime((System.currentTimeMillis() - startTime) + "");
        log.setReqParas(JSONObject.toJSONString(request));
        if (null != response) {
            log.setReturnCode(response.getReturnCode());
            log.setReturnMessage(response.getReturnMessage());
        } else {
            log.setReturnCode(null);
            log.setReturnMessage(null);
        }

        logger.debug(JSONObject.toJSONString(log));
    }

    /**
     * 后置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    // @After("controllerAspect()")
    public void after(JoinPoint joinPoint) {
        logger.info("用于拦截Controller层记录用户的操作" + joinPoint.toShortString());
    }

    //配置后置返回通知,使用在方法aspect()上注册的切入点
    //@AfterReturning("controllerAspect()")
    public void afterReturn(JoinPoint joinPoint) {
        logger.info("用于拦截Controller层记录用户的操作" + joinPoint.toShortString());
    }

    /**
     * 异常通知 用于拦截记录异常日志
     *
     * @param joinPoint
     * @param e
     */
    // @AfterThrowing(pointcut = "controllerAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        logger.info("用于拦截Controller层记录用户的操作" + joinPoint.toShortString() + "Throwable:" + e.getMessage());
    }
}

class MonitorReq {
    String className;//类名
    String reqParas;//请求入参（非空）
    String resParas;//请求出参(非空)
    String time;//耗时
    String custId;//客户编号
    private String returnCode;//返回代码
    private String returnMessage;//返回消息

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getReqParas() {
        return reqParas;
    }

    public void setReqParas(String reqParas) {
        this.reqParas = reqParas;
    }

    public String getResParas() {
        return resParas;
    }

    public void setResParas(String resParas) {
        this.resParas = resParas;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
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
