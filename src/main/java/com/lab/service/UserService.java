package com.lab.service;

import java.util.List;

import com.lab.pojo.User;

public interface UserService {
    public List<User> getUser();//提供获得用户服务
    User registerUser(User user);//提供注册服务
    User loginUser(String userName, String userPwd);//提供登录服务
    int update(User user);
    List<User> getListUser(Integer start);//提供后台获得分页用户服务
    List<User> getSearchUser(String search);//提供搜索后台获得分页用户服务
    User getUser(Integer id);//根据ID获得用户
    User getUser(String username);//根据用户名获得用户
}
