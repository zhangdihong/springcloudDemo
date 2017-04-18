package io.github.zhangdihong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * <p>Project: io.github.zhangdihong</p>
 * <p>Title: GatewayApplication.java</p>
 * <p/>
 * <p>Description: GatewayApplication </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/4/4
 */
@SpringBootApplication
@EnableZuulProxy
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
//    @Bean
//    public PatternServiceRouteMapper serviceRouteMapper(){
//        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)","${version}/${name}");
//    }

}
