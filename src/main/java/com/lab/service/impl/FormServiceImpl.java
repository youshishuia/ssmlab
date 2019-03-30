package com.lab.service.impl;

import com.lab.dao.FormDao;
import com.lab.pojo.Form;
import com.lab.pojo.FormView;
import com.lab.service.FormService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("formService")
public class FormServiceImpl implements FormService {
    @Resource(name = "formDao")
    private FormDao formDao;
    public Form getForm(int labid){
        return formDao.selectBylabid(labid);
    }
    public List<Form> getForm (){
        return  formDao.selectAllForm();
    }
    public int reservation (Form form){return formDao.insert(form);}

    @Override
    public List<FormView> getUserFormView(int userid) {
        return formDao.selectUserFormView(userid);
    }
    public List<FormView> getFormView(int count) {
        int newcount = 6*count;
        return formDao.selectFormView(newcount);
    }
    public List<FormView> getSearchFW(String search){
        return formDao.selectSearchFW(search);
    }//提供搜索获得分页预约表视图服务
    public int cancer(int id){
        return  formDao.deleteByPrimaryKey(id);
    };
}
