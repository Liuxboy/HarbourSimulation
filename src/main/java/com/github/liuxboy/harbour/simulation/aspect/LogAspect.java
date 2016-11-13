package com.github.liuxboy.harbour.simulation.aspect;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Package: com.letv.club.aspect <br>
 * Author: liuchundong <br>
 * Date: 2016/11/9 <br>
 * Time: 13:08 <br>
 * Desc:
 */
@Aspect
@Component
public class LogAspect {
    private static final Log logger = LogFactory.getLog(LogAspect.class);

    @Around(value = "@annotation(com.github.liuxboy.harbour.simulation.aspect.LogMonitor)")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("监控方法开始->");
        sb.append(proceedingJoinPoint.getSignature().toShortString());
        sb.append(", 方法入参:").append(arg2String(proceedingJoinPoint.getArgs()));
        Object result = proceedingJoinPoint.proceed();
        sb.append(". 方法结束, 耗时:").append(System.currentTimeMillis() - start).append("ms");
        logger.debug(sb.toString());
        return result;
    }

    private String arg2String(Object[] objects) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (null != objects) {
            for (Object object : objects) {
                stringBuilder.append(object.getClass().getSimpleName())
                        .append("->")
                        .append(JSONObject.toJSONString(object))
                        .append(";");
            }
        }
        return stringBuilder.toString();
    }
}
