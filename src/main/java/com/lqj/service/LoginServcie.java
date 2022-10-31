package com.lqj.service;

import com.lqj.dto.ResponseResult;
import com.lqj.entity.User;

/**
 * @Author lqj
 * @Date 2022-10-24 15:27
 */
public interface LoginServcie{

    ResponseResult login(User user);

    ResponseResult logout();
}
