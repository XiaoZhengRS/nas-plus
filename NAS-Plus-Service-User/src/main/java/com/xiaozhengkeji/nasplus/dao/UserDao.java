package com.xiaozhengkeji.nasplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaozhengkeji.nasplus.entitys.UserPoJo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<UserPoJo> {
}
