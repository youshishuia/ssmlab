package com.lab.service;

import com.lab.pojo.Form;
import com.lab.pojo.FormView;

import java.util.List;

public interface FormService {
    Form getForm(int labid);//通过实验室id获得form
    List<Form> getForm ();//获得所有form
    int reservation (Form form);//预约服务
    List<FormView> getUserFormView(int userid);//获得该ID所有用户预约视图表服务
    int cancer(int id);//取消预约服务
    List<FormView> getFormView(int count);//获得所有用户预约视图表服务
    List<FormView> getSearchFW(String search);//提供搜索获得分页预约表视图服务
}
