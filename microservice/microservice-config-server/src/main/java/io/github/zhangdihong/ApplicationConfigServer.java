package io.github.zhangdihong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * <p>Project: io.github.zhangdihong</p>
 * <p>Title: ApplicatinConfigServer.java</p>
 * <p/>
 * <p>Description: ApplicatinConfigServer </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/4/5
 */
@SpringBootApplication
@EnableConfigServer
public class ApplicationConfigServer {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfigServer.class,args);
    }

}
