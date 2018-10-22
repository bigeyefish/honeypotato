package com.honeypotato.common.aop;

import com.alibaba.fastjson.JSON;
import com.honeypotato.common.common.LogUtil;
import com.honeypotato.common.common.SysUtil;
import com.honeypotato.common.model.ReqLogInfo;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * aop记录操作日志
 *
 * @author sanyihwang.
 * created on 2018/9/29
 **/
@Aspect
@Component
@Log4j2(topic = "request")
public class AspectLog {

    private static final String REQ_START_TIME = "REQ_START_TIME";
    private static final String LOGTYPE_INFO = "info";
    private static final String LOGTYPE_ERROR = "error";

    /**
     * 定义切点
     */
    @Pointcut("@annotation(com.honeypotato.common.aop.ReqLog)")
    public void methodCachePointcut() {
    }

    @Before("methodCachePointcut()")
    public void doBefore(JoinPoint p) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        request.setAttribute(REQ_START_TIME, System.currentTimeMillis());
    }

    @AfterThrowing(pointcut = "methodCachePointcut()", throwing = "e")
    public void doAfterThrowing(JoinPoint p, Throwable e) {
        reqInfo2log(p, LOGTYPE_ERROR, e.getMessage());
    }

    @AfterReturning(returning = "result", pointcut = "methodCachePointcut()")
    public void doAfterReturning(JoinPoint p, Object result) {
       reqInfo2log(p, LOGTYPE_INFO, result);
    }

    /**
     * 记录日志
     */
    public void reqInfo2log(JoinPoint p, String type, Object result) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        ReqLogInfo logInfo = new ReqLogInfo();
        logInfo.setReqTime((Long) request.getAttribute(REQ_START_TIME));
        logInfo.setMethod(p.getTarget().getClass() + "." + p.getSignature().getName());
        // logInfo.setUserId(SysUtil.currentUserId());
        logInfo.setUrl(request.getRequestURI());
        logInfo.setSessionId(request.getSession().getId());
        logInfo.setReqMethod(request.getMethod());
        logInfo.setIp(SysUtil.getIp(request));
        logInfo.setReqTime(System.currentTimeMillis());
        logInfo.setType(type);
        if ("POST".equals(request.getMethod())) {
            logInfo.setParams(JSON.toJSONString(p.getArgs()));
        } else {
            Map<?, ?> paramsMap = (Map<?, ?>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
            logInfo.setParams(paramsMap.toString());
        }

        logInfo.setCostTime((System.currentTimeMillis() - logInfo.getReqTime()) / 1000);
        if (null != result) {
            logInfo.setResult(JSON.toJSONString(result));
        }
        Method method = ((MethodSignature)p.getSignature()).getMethod();
        ReqLog annotation = method.getAnnotation(ReqLog.class);
        if (!StringUtils.isEmpty(annotation.topic())) {
            LogUtil.getLogger(annotation.topic()).info(logInfo);
        } else {
            log.info(logInfo);
        }
    }
}
