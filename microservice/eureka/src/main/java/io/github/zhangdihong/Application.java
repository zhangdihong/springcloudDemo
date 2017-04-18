package io.github.zhangdihong;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
;

/**
 * <p>Project: io.github.zhangdihong</p>
 * <p>Title: Application.java</p>
 * <p/>
 * <p>Description: Application </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/3/18
 */
@SpringBootApplication
@EnableEurekaServer
public class Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setBannerMode(Banner.Mode.OFF);
        SpringApplication.run(Application.class, args);
    }
}