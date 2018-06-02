package fqj.csu.configuration;

import fqj.csu.interceptor.LoginRequredInterceptor;
import fqj.csu.interceptor.PassportInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class BlackTeaConfiguration extends WebMvcConfigurerAdapter {
    @Autowired
    PassportInterceptor passportInterceptor;

    @Autowired
    LoginRequredInterceptor loginRequredInterceptor;


    //通过registry.addInterceptor()方法添加拦截器，注意前面的拦截器先执行
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(passportInterceptor);
//        registry.addInterceptor(loginRequredInterceptor).addPathPatterns("/");//需要添加addPathPatterns函数，表示在哪些页面使用该拦截器
        super.addInterceptors(registry);
    }
}

