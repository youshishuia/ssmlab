package com.lab.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.dao.UserDao;
import com.lab.service.UserService;
import com.lab.pojo.User;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Service("userService")
public class UserServiceImpl implements UserService{

    @Resource(name = "userDao")
    private UserDao userDao;
     @Override
    public List<User> getUser() {
        return userDao.selectAllUser();
    }
    //注册服务
    public List<User> getListUser(Integer start){
        int newstart = 6*start;
         return userDao.selectListUser(newstart);
    }
    public List<User> getSearchUser(String search){
         return userDao.selectSearchUser(search);
    }
    public User registerUser(User user){
        //如果用户名存在就返回null，如果不存在就添加一个新用户
        if (userDao.selectByusn(user.getUsername())!=null) {

            return null;
                    }
        userDao.insert(user);
        return user;
            }
    public User loginUser(String username, String password) {
        return userDao.selectByusnpsw(username, password);
         }
    public int update (User user){
         return userDao.updateByPrimaryKey(user);
    }
    public User getUser(Integer id){
         return userDao.selectByPrimaryKey(id);
    }
    public User getUser(String username){
         return  userDao.selectByusn(username);
    }

}



