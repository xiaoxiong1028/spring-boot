package com.ibears.miaosha.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author xiaoxiong
 * @date 2019/1/5 21:29
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    
    @Autowired
    private UserArgumentResolver userArgumentResolver;
    
    
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userArgumentResolver);
    }
}
