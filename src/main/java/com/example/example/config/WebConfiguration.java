package com.example.example.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.common.collect.Lists;
import java.nio.charset.Charset;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.IntrospectorCleanupListener;

@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * 这个需要根据具体项目的servlet-context.xml来具体配置
     */
    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        stringHttpMessageConverter.setDefaultCharset(Charset.forName("UTF-8"));
        stringHttpMessageConverter
            .setSupportedMediaTypes(Lists.newArrayList(MediaType.TEXT_PLAIN, MediaType.TEXT_HTML));
        return stringHttpMessageConverter;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter =
            new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setDefaultCharset(Charset.forName("UTF-8"));
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(
            Lists.newArrayList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED));
        return mappingJackson2HttpMessageConverter;
    }

    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        fastJsonHttpMessageConverter.setDefaultCharset(Charset.forName("UTF-8"));
        fastJsonHttpMessageConverter.setSupportedMediaTypes(
            Lists.newArrayList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED));
        return fastJsonHttpMessageConverter;
    }

//    @Bean
//    public HttpRequestAspect httpRequestAspect() {
//        return new HttpRequestAspect();
//    }

//    @Bean
//    public ControllerExceptionResolver controllerExceptionResolver() {
//        return new ControllerExceptionResolver();
//    }

    @Bean
    public CommonsMultipartResolver commonsMultipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("UTF-8");
        commonsMultipartResolver.setMaxUploadSize(20971520);
        commonsMultipartResolver.setMaxInMemorySize(4096);
        return commonsMultipartResolver;
    }

    /**
     * 注册listener
     */
    @Bean
    public ServletListenerRegistrationBean<IntrospectorCleanupListener> getServletListenerRegistrationBean() {
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean(new IntrospectorCleanupListener());
        return bean;
    }

    //过滤器方式二：在启动类中创建一个新的filter对象，加载到spring容器中，然后但凡以他配置的过滤的后缀名结束的请求都会过滤掉，
    @Bean
    public FilterRegistrationBean getFilterRegistrationBean() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        FilterRegistrationBean bean = new FilterRegistrationBean(characterEncodingFilter);
        bean.addUrlPatterns("/*");
        return bean;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*").allowedOrigins("*").allowedMethods("GET", "POST", "HEAD", "PUT", "DELETE")
            .allowedHeaders("Content-Type", "Last-Modified").exposedHeaders("Set-Cookie").allowCredentials(true);
    }

}
