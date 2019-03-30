package com.lab.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.lab.pojo.User;

@Repository("userDao")
public interface UserDao {
    int deleteByPrimaryKey(Integer id);//给定ID删除用户

    int insert(User user);//增加用户

    //int insertSelective(User record);

    User selectByPrimaryKey(Integer id);//根据ID获得用户

    User selectByusnpsw(String username,String password);//根据用户名和密码获得用户

    User selectByusn(String username);//根据用户名获得用户
    //int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User user);///更新用户信息
    //自己添加的，已匹配Mapper中的Sql
    List<User> selectAllUser();//取得所有用户
    List<User> selectListUser(Integer start);//获得从start开始的6个用户
    List<User> selectSearchUser(String search);//搜索获得从start开始的6个用户
}
