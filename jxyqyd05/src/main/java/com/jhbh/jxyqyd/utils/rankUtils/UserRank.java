package com.jhbh.jxyqyd.utils.rankUtils;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:Hayden
 * @Date:2019/5/20
 * 将该注释使用在方法上，用于判断处理该请求的用户是否有权限
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserRank {

}
