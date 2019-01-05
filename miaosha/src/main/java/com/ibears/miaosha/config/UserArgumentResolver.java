package com.ibears.miaosha.config;

import com.alibaba.druid.util.StringUtils;
import com.ibears.miaosha.domain.MiaoshaUser;
import com.ibears.miaosha.service.MiaoshaUserService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author xiaoxiong
 * @date 2019/1/5 21:58
 */
@Service
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    
    @Autowired
    private MiaoshaUserService miaoshaUserService;
    
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Class<?> clazz = methodParameter.getParameterType();
        return clazz == MiaoshaUser.class;
    }
    
    @Nullable
    @Override
    public Object resolveArgument(MethodParameter methodParameter, @Nullable ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, @Nullable WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest  request     = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response    = nativeWebRequest.getNativeResponse(HttpServletResponse.class);
        String              paramToken  = request.getParameter(MiaoshaUserService.COOKIE_NAME_TOKEN);
        String              cookieToken = getCookieValue(request, MiaoshaUserService.COOKIE_NAME_TOKEN);
        if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
            return null;
        }
        String token = StringUtils.isEmpty(cookieToken) ? paramToken : cookieToken;
        return miaoshaUserService.getByToken(response, token);
    }
    
    
    public String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }
        return null;
    }
    
    
}
