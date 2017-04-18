package io.github.zhangdihong.config;

import feign.Contract;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Project: io.github.zhangdihong.config</p>
 * <p>Title: FeignConfiguration.java</p>
 * <p/>
 * <p>Description: FeignConfiguration </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/3/26
 */
@Configuration
public class FeignConfiguration {

    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("","");
    }

//    @Bean
//    @Scope(value = "prototype")
//    public Feign.Builder builder(){
//        return Feign.builder();
//    }
}
