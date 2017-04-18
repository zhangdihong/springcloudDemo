package io.github.zhangdihong.server.controller;

import io.github.zhangdihong.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Project: io.github.zhangdihong.server.controller</p>
 * <p>Title: UserController.java</p>
 * <p/>
 * <p>Description: UserController </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/3/26
 */
@RestController
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping(value = "/user/getOne")
    public User getOne(){
            return userFeignClient.getUser();
    }

    @RequestMapping(value = "/user/other")
    public String getUsers(){
        return userFeignClient.getUsers();
    }

}
