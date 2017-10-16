package com.heartBar.sharedDiary.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;

/**
 * @author zhangxy 2017/9/26 16:24
 */
@Aspect
@Component
public class ServiceProxy {

    Logger LOG = LoggerFactory.getLogger(ServiceProxy.class);

    @Pointcut("@annotation(com.heartBar.sharedDiary.common.aop.ServiceLog)")
    public void cutController() {
    }

    @Around(value = "cutController()")
    public Object proceedController(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        ServiceLog serviceLog = method.getAnnotation(ServiceLog.class);
        /** 方法名称 */
        String methodName = method.getName();
        /** 类名 */
        String targetName = point.getTarget().getClass().getName();
        //获取request
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        LOG.debug("调用"+targetName+"."+methodName+"("+serviceLog.value()+")"+getRequestInfo(request));
        Object obj = null;
        try {
            obj = point.proceed();
        } catch (Exception e) {
            LOG.error("{}失败，{}。{}", methodName, e.getMessage(), e);
            obj = e;
        }
        if (LOG.isDebugEnabled()){
            LOG.debug("{}的接口用时:{}毫秒", methodName, System.currentTimeMillis() - start);
        }
        return obj;
    }


    public String getRequestInfo(HttpServletRequest request) throws IOException {
        StringBuffer sb = new StringBuffer();
        Enumeration enumeration = request.getParameterNames();
        sb.append("接口").append(request.getRequestURI()).append("请求参数-----------");
        while (enumeration.hasMoreElements()) {
            String name = (String) enumeration.nextElement();
            String value = request.getParameter(name);
            if (!StringUtils.isEmpty(value)) {
                sb.append(name).append("=").append(value).append(" & ");
            }
        }
        return sb.substring(0, sb.length() - 3);
    }
}
