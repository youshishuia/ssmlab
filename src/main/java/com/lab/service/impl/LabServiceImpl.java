package com.lab.service.impl;

import com.lab.dao.LabDao;
import com.lab.pojo.Lab;
import com.lab.service.LabService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("labService")
public class LabServiceImpl implements LabService {

    @Resource(name = "labDao")
    private LabDao labDao;
    public Lab getLab(String name){
        return labDao.selectBylan(name);
    }
    public Lab getLabByAddress(String address){
        return  labDao.selectByladdress(address);
    }
    public List<Lab> getLab(Integer start){
        int newstart = 6*start;
        return labDao.selectAllLab(newstart);
    }
    public  List<Lab> getSearchLab(String search){
        return labDao.selectSearchLab(search);
    }
}
