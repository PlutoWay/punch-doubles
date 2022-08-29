package com.tencent.wxcloudrun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tencent.wxcloudrun.dao.UserMapper;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  final UserMapper userMapper;

  public UserServiceImpl(@Autowired UserMapper userMapper) {
    this.userMapper = userMapper;
  }


  @Override
  public boolean insertUser(User user) {
    List<User> users = userMapper.selectList(new QueryWrapper<User>().eq("openId",user.getOpenId()));
    if(users.size() == 0){
      int booleanint = userMapper.insert(user);
      if(booleanint == 1){
        return true;
      }
    }
    return false;
  }
}
