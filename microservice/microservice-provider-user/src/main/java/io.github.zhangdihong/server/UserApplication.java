package io.github.zhangdihong.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>Project: io.github.zhangdihong</p>
 * <p>Title: io.github.zhangdihong.server.UserApplication.java</p>
 * <p/>
 * <p>Description: io.github.zhangdihong.server.UserApplication </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/3/19
 */
@SpringBootApplication
@EnableEurekaClient
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
