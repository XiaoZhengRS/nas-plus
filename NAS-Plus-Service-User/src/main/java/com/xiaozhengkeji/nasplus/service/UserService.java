package com.xiaozhengkeji.nasplus.service;

import com.xiaozhengkeji.nasplus.entitys.UserPoJo;

import java.util.List;

public interface UserService {
    boolean add(UserPoJo userPoJo);

    UserPoJo getUserById(Integer id);

    List<UserPoJo> getALLUser();

    boolean setUserByUserName(String userName, UserPoJo userPoJo);
}
