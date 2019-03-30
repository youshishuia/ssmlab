package com.lab.dao;

import com.lab.pojo.Form;
import com.lab.pojo.FormView;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("formDao")
public interface FormDao {
    Form selectBylabid(int id);//根据实验室id获得实验室预约表

    Form selectByusid(int id);//根据用户id获得实验室预约表

    List<Form> selectAllForm();//获得所有实验室预约表

    List<FormView> selectUserFormView(int userid);//获得该id所有用户预约视图表

    List<FormView> selectFormView(int count);//获得所有用户预约视图表

    List<FormView> selectSearchFW(String search);//搜索获得从count开始的6个预约表视图


    int update(Form form);//更新实验室预约表信息（暂留）

    int insert(Form form);//增加实验室预约表（暂留）

    int deleteByPrimaryKey(Integer id);//给定ID删除实验室预约表（暂留）

    Map<String,Object> selectFormBylabid(int id);//给定实验室id获得有用户名，实验室名和预约时间的预约表

}
