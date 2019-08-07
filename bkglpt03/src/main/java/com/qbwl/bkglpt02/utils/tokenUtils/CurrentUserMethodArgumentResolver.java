package com.qbwl.bkglpt02.utils.tokenUtils;

import com.qbwl.bkglpt02.entity.User;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * @author:Hayden
 * @Date:2019/5/10
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    /**
     * supportsParameter：用于判定是否需要处理该参数分解，返回true为需要，并会去调用下面的方法resolveArgument。
     *resolveArgument：真正用于处理参数分解的方法，返回的Object就是controller方法上的形参对象。
     * */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        System.out.println("----------supportsParameter-----------" + parameter.getParameterType());
        return parameter.getParameterType().isAssignableFrom(User.class)//判断是否能转成UserBase 类型
                && parameter.hasParameterAnnotation(CurrentUser.class);//是否有CurrentUser注解
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        System.out.println("--------------resolveArgument-------------" + parameter);
        User user = (User) webRequest.getAttribute(CurrentUserConstants.CURRENT_USER, RequestAttributes.SCOPE_REQUEST);
        if (user != null) {
            return user;
        }
        throw new MissingServletRequestPartException(CurrentUserConstants.CURRENT_USER);
    }

//    原文：https://blog.csdn.net/qq_27828675/article/details/80923678
}
