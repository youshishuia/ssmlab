package com.lab.service;

import com.lab.pojo.Lab;


import java.util.List;

public interface LabService {
    Lab getLab(String name);//通过实验室名获得实验室
    Lab getLabByAddress(String address);//通过实验室地址获得实验室
    List<Lab> getLab(Integer start);//提供获得分页实验室服务
    List<Lab> getSearchLab(String search);//提供搜索获得分页实验室服务
}
