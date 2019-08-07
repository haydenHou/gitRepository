package com.qbwl.bkglpt02.aspect.anno;

import java.lang.annotation.*;

/**
 * 定义系统日志注解
 * @author zhuzhe
 * @date 2018/6/4 9:24
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    String value() default "";
}
