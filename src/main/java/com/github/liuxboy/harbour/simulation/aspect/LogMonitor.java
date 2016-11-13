package com.github.liuxboy.harbour.simulation.aspect;

import java.lang.annotation.*;

/**
 * Package: com.letv.club.aspect <br>
 * Author: liuchundong <br>
 * Date: 2016/11/11 <br>
 * Time: 17:44 <br>
 * Desc: 需要用AOP监控日志的注解标签
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogMonitor {
    String value() default "";
}
