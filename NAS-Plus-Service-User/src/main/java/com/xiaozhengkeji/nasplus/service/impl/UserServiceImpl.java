package com.xiaozhengkeji.nasplus.service.impl;


import com.xiaozhengkeji.nasplus.entitys.UserPoJo;
import com.xiaozhengkeji.nasplus.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public boolean add(UserPoJo userPoJo) {
        return false;
    }

    @Override
    public UserPoJo getUserById(Integer id) {
        return null;
    }

    @Override
    public UserPoJo getUserByUserName(String userName) {
        return null;
    }

    @Override
    public List<UserPoJo> getALLUser() {
        return null;
    }

    @Override
    public boolean setUserByUserName(String userName, UserPoJo userPoJo) {
        return false;
    }
}
