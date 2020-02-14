package com.xiaozhengkeji.nasplus.controller;

import com.xiaozhengkeji.nasplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @HystrixCommand(fallbackMethod = "方法名")
 * <p>
 * 服务熔断
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;


}
