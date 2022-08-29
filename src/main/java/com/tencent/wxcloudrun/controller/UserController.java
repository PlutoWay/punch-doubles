package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * counter控制器
 */
@RestController

public class UserController {

  final UserService userService;
  final Logger logger;

  public UserController(@Autowired UserService userService) {
    this.userService = userService;
    this.logger = LoggerFactory.getLogger(UserController.class);
  }


    /**
     * 插入用户数据
   * @param user
     * @return
     */
  @PostMapping(value = "/api/user/insert")
  ApiResponse insert(@RequestBody User user) {
    logger.info("/api/user/insert get request");
    if(userService.insertUser(user)){
      return ApiResponse.ok();
    }
    return ApiResponse.error("插入失败");
  }



}