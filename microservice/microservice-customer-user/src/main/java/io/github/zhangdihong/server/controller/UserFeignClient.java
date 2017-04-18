package io.github.zhangdihong.server.controller;

import feign.RequestLine;
import io.github.zhangdihong.config.FeignConfiguration;
import io.github.zhangdihong.server.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Project: io.github.zhangdihong.server.controller</p>
 * <p>Title: UserFeignClient.java</p>
 * <p/>
 * <p>Description: UserFeignClient </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/3/26
 */
@FeignClient(value = "microservice-provider-user",configuration = FeignConfiguration.class,fallback = UserFallBack.class)
public interface UserFeignClient {
    @RequestLine("GET /user/getOne")
    public User getUser();

    @RequestLine("GET /user/other")
    public String getUsers();

}
