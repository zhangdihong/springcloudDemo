package io.github.zhangdihong.server.controller;

import io.github.zhangdihong.server.model.User;
import org.springframework.stereotype.Component;

/**
 * <p>Project: io.github.zhangdihong.server.controller</p>
 * <p>Title: UserFallBack.java</p>
 * <p/>
 * <p>Description: UserFallBack </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/3/26
 */
@Component
public class UserFallBack implements UserFeignClient {

    @Override
    public User getUser() {
        User user = new User();
        user.setId("0");
        user.setSex("");
        user.setName("aa");
        user.setAge("22");
        return user;
    }

    @Override
    public String getUsers() {
        return null;
    }
}
