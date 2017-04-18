package io.github.zhangdihong.server.controller;

import io.github.zhangdihong.server.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Project: io.github.zhangdihong.server.controller</p>
 * <p>Title: UserController.java</p>
 * <p/>
 * <p>Description: UserController </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/3/19
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @RequestMapping(value = "getOne")
    public User getUser(HttpServletRequest request){
        System.out.println(request.getServletPath()+"请求servelet地址");
        System.out.println(request.getServerPort()+"请求端口号");
        User user = new User();
        user.setAge("18");
        user.setId("1");
        user.setName("我的姓名");
        user.setSex("未知");
        return user;
    }
    @RequestMapping(value = "other")
    public String getUsers(){
        return "aaaaaaaaa";
    }
}
