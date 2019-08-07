package com.qbwl.bkglpt02.utils.tokenUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:Hayden
 * @Date:2019/5/10
 * 在Controller的方法参数中使用此注解，该方法在映射时会注入当前登录的User对象
 */

@Target(ElementType.PARAMETER)          // 可用在方法的参数上
@Retention(RetentionPolicy.RUNTIME)     // 运行时有效
public @interface CurrentUser {
}
