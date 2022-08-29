package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

  private Integer id;

  private String openId;

  private String nickName;

  private String headImg;
}
