package com.jhbh.jxyqyd.interceptor;

import com.jhbh.jxyqyd.exception.PermissionDeniedException;
import com.jhbh.jxyqyd.exception.TokenOutmodedException;
import com.jhbh.jxyqyd.exception.UserNotFoundException;
import com.jhbh.jxyqyd.service.comService.IComWorkerService;
import com.jhbh.jxyqyd.utils.GetIpUtils;
import com.jhbh.jxyqyd.utils.rankUtils.UserRank;
import com.jhbh.jxyqyd.utils.tokenUtils.CurrentUserConstants;
import com.jhbh.jxyqyd.utils.tokenUtils.LoginRequired;
import com.jhbh.jxyqyd.utils.tokenUtils.TokenUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author:Hayden
 * @Date:2019/4/9
 */
public  class SecurityInterceptor implements HandlerInterceptor {

    @Autowired
    IComWorkerService userService;

    private Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("URL:{}，IP:{}",request.getRequestURL(), GetIpUtils.getIpAddr(request));
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 判断接口是否需要登录
        LoginRequired methodAnnotation = method.getDeclaringClass().getAnnotation(LoginRequired.class);
        LoginRequired methodAnnotations = method.getAnnotation(LoginRequired.class);
//        类上和方法上都没有注解的情况下
        // 有 @LoginRequired 注解，需要认证
        if (methodAnnotation != null || methodAnnotations!=null) {
        // 判断权限
            judgeAuthority(method,request);
        // 判断是否存在令牌信息，如果存在，则允许登录
            String accessToken = request.getHeader("token");

            if (null == accessToken) {
                throw new UserNotFoundException("无token，请登录");
            } else {
                // 从Redis 中查看 token 是否过期
                Claims claims;
                try{
                    claims = TokenUtils.parseJWT(accessToken);
                }catch (ExpiredJwtException e){
                    throw new TokenOutmodedException("token失效，请重新登录");
                }catch (SignatureException se){
                    throw new TokenOutmodedException("无token，请登录");
                }
                // 当前登录用户@CurrentUser
                request.setAttribute(CurrentUserConstants.CURRENT_USER, claims.getId());
                return true;
            }
        } else {//不需要登录可请求
            return true;
        }
    }


    /**
     * 当方法包含用户权限注解时,获取用户权限并做分析
     */
    private Boolean judgeAuthority(Method method,HttpServletRequest request){
        // 判断接口是否需要登录
        UserRank methodAnnotation = method.getAnnotation(UserRank.class);
        //如果不存在权限注解，直接放行
        if(methodAnnotation != null){
            if("0".equals(TokenUtils.getUserNameOrRankFromJwt(request,1))){
                return true;
            }else {
//                return false;
                throw new PermissionDeniedException("权限不足");
            }
        }
            return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
