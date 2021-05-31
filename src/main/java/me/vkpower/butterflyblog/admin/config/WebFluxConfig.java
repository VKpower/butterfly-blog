package me.vkpower.butterflyblog.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 *
 * 配置web
 *
 * @author xaiyuancheng
 * @date 2020/4/16 - 18:44
 */
//@Configuration
public class WebFluxConfig implements WebFluxConfigurer {

    /**
     * 监听器：监听HTTP请求事件
     * 解决RequestContextHolder.getRequestAttributes()空指针问题
     * @return
     */
    @Bean
    public RequestContextListener requestContextListener(){
        return new RequestContextListener();
    }

}