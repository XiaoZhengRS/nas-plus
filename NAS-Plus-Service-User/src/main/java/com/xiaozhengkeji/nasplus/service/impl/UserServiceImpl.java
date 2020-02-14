package com.xiaozhengkeji.nasplus.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaozhengkeji.nasplus.dao.PermissionDao;
import com.xiaozhengkeji.nasplus.dao.RoleDao;
import com.xiaozhengkeji.nasplus.dao.RolepermissionDao;
import com.xiaozhengkeji.nasplus.dao.UserDao;
import com.xiaozhengkeji.nasplus.entitys.PermissionPoJo;
import com.xiaozhengkeji.nasplus.entitys.RolePoJo;
import com.xiaozhengkeji.nasplus.entitys.UserPoJo;
import com.xiaozhengkeji.nasplus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RolepermissionDao rolepermissionDao;

    @Override
    public boolean add(UserPoJo userPoJo) {
        if (userDao.insert(userPoJo) < 1) {
            return false;
        }
        return true;
    }

    @Override
    public UserPoJo getUserById(Integer id) {
        QueryWrapper<UserPoJo> queryWrapperUser = new QueryWrapper<UserPoJo>();
        queryWrapperUser.eq("id", id);
        UserPoJo userPoJo = userDao.selectOne(queryWrapperUser);
        QueryWrapper<RolePoJo> queryWrapperRole = new QueryWrapper<RolePoJo>();
        queryWrapperRole.eq("rid", userPoJo.getRid());
        userPoJo.setRole(roleDao.selectOne(queryWrapperRole));
        QueryWrapper<PermissionPoJo> queryWrapperpermission = new QueryWrapper<PermissionPoJo>();
        queryWrapperpermission.eq("rid", userPoJo.getRid());
        userPoJo.setPermissions(permissionDao.selectList(queryWrapperpermission));
        return userPoJo;
    }

    @Override
    public UserPoJo getUserByUserName(String userName) {
        QueryWrapper<UserPoJo> queryWrapperUser = new QueryWrapper<UserPoJo>();
        queryWrapperUser.eq("username", userName);
        UserPoJo userPoJo = userDao.selectOne(queryWrapperUser);
        QueryWrapper<RolePoJo> queryWrapperRole = new QueryWrapper<RolePoJo>();
        queryWrapperRole.eq("rid", userPoJo.getRid());
        userPoJo.setRole(roleDao.selectOne(queryWrapperRole));
        QueryWrapper<PermissionPoJo> queryWrapperpermission = new QueryWrapper<PermissionPoJo>();
        queryWrapperpermission.eq("rid", userPoJo.getRid());
        userPoJo.setPermissions(permissionDao.selectList(queryWrapperpermission));
        return userPoJo;
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
