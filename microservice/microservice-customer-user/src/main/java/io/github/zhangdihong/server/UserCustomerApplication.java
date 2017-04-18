package io.github.zhangdihong.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * <p>Project: PACKAGE_NAME</p>
 * <p>Title: io.github.zhangdihong.server.UserCustomerApplication.java</p>
 * <p/>
 * <p>Description: io.github.zhangdihong.server.UserCustomerApplication </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/3/26
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrix
public class UserCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCustomerApplication.class,args);
    }

}
