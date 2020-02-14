package com.xiaozhengkeji.nasplus.controller;

import com.alibaba.fastjson.JSONArray;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xiaozhengkeji.nasplus.bean.LoginBean;
import com.xiaozhengkeji.nasplus.entitys.UserPoJo;
import com.xiaozhengkeji.nasplus.jwt.JWTUtil;
import com.xiaozhengkeji.nasplus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @HystrixCommand(fallbackMethod = "方法名")
 * <p>
 * 服务熔断
 */

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @HystrixCommand(fallbackMethod = "addFallback")
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public boolean add(@RequestBody UserPoJo userPoJo) {
        return userService.add(userPoJo);
    }

    public boolean addFallback(@RequestBody UserPoJo userPoJo) {
        log.error("启动服务熔断机制!\n" + userPoJo.toString());
        return false;
    }

    @HystrixCommand(fallbackMethod = "getUserByIDFallbac")
    @RequestMapping(value = "/user/getbyid/{id}", method = RequestMethod.GET)
    public UserPoJo getUserByID(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    public UserPoJo getUserByIDFallbac(@PathVariable("id") int id) {
        return new UserPoJo().setId(0).setPassword("服务熔断").setUsername("服务熔断");
    }

    @HystrixCommand(fallbackMethod = "getUserByNameFallbac")
    @RequestMapping(value = "/user/getbyname/{name}", method = RequestMethod.GET)
    public UserPoJo getUserByName(@PathVariable("name") String name) {
        return userService.getUserByUserName(name);
    }

    public UserPoJo getUserByNameFallbac(@PathVariable("name") String name) {
        return new UserPoJo().setId(0).setPassword("服务熔断").setUsername("服务熔断");
    }

    @HystrixCommand(fallbackMethod = "loginFallbac")
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public LoginBean login(@RequestBody UserPoJo user) {
        UserPoJo userPoJo = userService.getUserByUserName(user.getUsername());
        if (userPoJo != null) {
            if (userPoJo.getPassword().equalsIgnoreCase(user.getPassword())) {
                //登陆成功
                return new LoginBean().setToken(JWTUtil.生成签名(user.getUsername(), user.getPassword())).setUserPoJo(user);
            } else {
                //登陆失败
                return new LoginBean().setToken("登陆失败!用户密码错误!!");
            }
        } else {
            return new LoginBean().setToken("登陆失败!用户不存在!");
        }
    }

    public LoginBean loginFallbac(@RequestBody UserPoJo user) {
        log.error("启动服务熔断机制!\n" + user.toString());
        return new LoginBean().setToken("登陆失败!服务自动熔断!");
    }


}
