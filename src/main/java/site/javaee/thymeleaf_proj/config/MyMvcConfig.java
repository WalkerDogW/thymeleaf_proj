package site.javaee.thymeleaf_proj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import site.javaee.thymeleaf_proj.component.LoginHandlerInterceptor;
import site.javaee.thymeleaf_proj.component.MyLocaleResolver;

import java.util.Arrays;

/**
 * @author JunTao
 * @create 2020/4/12 3:01
 */
@Configuration
//编写一个配置类（@Configuration），是WebMvcConfigurerAdapter类型；不能标注@EnableWebMvc;
//既保留了所有的自动配置，也能用我们扩展的配置；
public class MyMvcConfig {
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
//        registry.addViewController("/site").setViewName("success");
//    }


    //所有的WebMvcConfigurerAdapter组件都会一起起作用


    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            //请求转发
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/dashboard.html").setViewName("dashboard");
            }


            //SpringBoot1.x访问静态文件只需要把文件放入static中即可，在SpringBoot2中需要配置addResourceHandlers
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                //第一个方法设置访问路径前缀，第二个方法设置资源路径
                registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
                //registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/webjars/");
            }

            //注册拦截器

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //springboot已经做了静态资源映射，我们不需要排除static文件夹下的拦截
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/*","/user/login","/webjars/**");
            }


        };
        return configurer;
    }

    //springboot2 弃用，会引起web自动配置失效
    /*
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {

            }
        };
        return adapter;
    }
     */

    //国际化语言处理
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}

//public class MyMvcConfig implements WebMvcConfigurer{
//
//}