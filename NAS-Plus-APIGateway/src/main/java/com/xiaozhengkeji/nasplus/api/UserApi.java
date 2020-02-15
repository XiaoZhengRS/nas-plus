package com.xiaozhengkeji.nasplus.api;

import com.xiaozhengkeji.nasplus.bean.LoginBean;
import com.xiaozhengkeji.nasplus.bean.ResponseBean;
import com.xiaozhengkeji.nasplus.entitys.UserPoJo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserApi {
    private static final String REST_URL_PREFIX = "http://service-user";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/login")
    public ResponseBean login(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpServletRequest request) {
        UserPoJo userPoJo = new UserPoJo();
        userPoJo.setUsername(username);
        userPoJo.setPassword(password);
        LoginBean loginBean = restTemplate.postForObject(REST_URL_PREFIX + "/user/login", userPoJo, LoginBean.class);
        return new ResponseBean(200, "ok", loginBean);
    }
}
