package com.teen.review.Configuration;

import com.teen.review.interceptor.logInInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author teen
 * @create 2021/10/15 8:39
 */
//记得配置类要加注解
@Configuration
public class InterceptorConf implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //将编写的拦截器注入容器中
        //代表拦截所有路径

        registry.addInterceptor(new logInInterceptor())
                .addPathPatterns("/**")
                //放行主页 注册页 错误页 登录请求
                .excludePathPatterns("/register.html","/register","/index.html","/","/error","/ierror.html","/logIn","/logUser");//配置要放行的路径 /index.html和 / 都得有
    }
}
