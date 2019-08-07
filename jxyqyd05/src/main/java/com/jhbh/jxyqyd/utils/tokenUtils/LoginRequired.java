package com.jhbh.jxyqyd.utils.tokenUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:Hayden
 * @Date:2019/5/10
 * 在需要登录验证的Controller的方法上使用此注解
 */
@Target({ElementType.METHOD,ElementType.TYPE})// 可用在方法名上
@Retention(RetentionPolicy.RUNTIME)// 运行时有效
public @interface LoginRequired {
}
