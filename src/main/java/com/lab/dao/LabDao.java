package com.lab.dao;

import org.springframework.stereotype.Repository;
import com.lab.pojo.Lab;

import java.util.List;

@Repository("labDao")
public interface LabDao {
    Lab selectBylan(String name);//根据实验室名获得实验室

    Lab selectByladdress(String address);//根据实验室地址获得实验室

    List<Lab> selectAllLab(Integer start);//获得从start开始的6个实验室

    List<Lab> selectSearchLab(String search);//搜索获得从start开始的6个实验室

    int update(Lab lab);//更新实验室信息（暂留）

    int insert(Lab lab);//增加实验室（暂留）

    int deleteByPrimaryKey(Integer id);//给定ID删除实验室（暂留）

}
