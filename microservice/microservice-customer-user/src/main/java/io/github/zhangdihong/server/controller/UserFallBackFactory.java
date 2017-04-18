package io.github.zhangdihong.server.controller;

import feign.hystrix.FallbackFactory;
import io.github.zhangdihong.server.model.User;
import org.springframework.stereotype.Component;

/**
 * <p>Project: io.github.zhangdihong.server.controller</p>
 * <p>Title: UserFallBackFactory.java</p>
 * <p/>
 * <p>Description: UserFallBackFactory </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/4/3
 */
@Component
public class UserFallBackFactory implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable throwable) {

        return new UserFeignClient() {

            @Override
            public User getUser() {
                return null;
            }

            @Override
            public String getUsers() {
                return null;
            }
        };
    }
}
