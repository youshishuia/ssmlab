package com.lab.controller;

import com.lab.pojo.Lab;
import com.lab.service.LabService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LabController {
    @Resource(name = "labService")
    LabService labService;

    @RequestMapping(value = "/findlabname")
    public ModelAndView findlabname(HttpServletRequest request) {
        String name = request.getParameter("name");
        ModelAndView mv = new ModelAndView();
        Lab lab = labService.getLab(name);
        mv.addObject("lab", lab);//根据名字查找实验室信息
        mv.setViewName("/WEB-INF/jsp/LRSlab");
        return mv;
    }

    @RequestMapping(value = "/findlaaddress")
    public ModelAndView findlaaddress(HttpServletRequest request) {
        String address = request.getParameter("address");
        ModelAndView mv = new ModelAndView();
        Lab lab = labService.getLabByAddress(address);
        mv.addObject("lab", lab);//根据名字查找实验室信息
        mv.setViewName("/WEB-INF/jsp/LRSlab");
        return mv;
    }

    @RequestMapping(value = "/LRSlab")//后续修改 多窗口操作session污染问题，刷新页面跳转下一页BUG问题
    public ModelAndView getALLLab(HttpSession httpSession) {
        int count = 0;
        ModelAndView mv = new ModelAndView();
        List<Lab> labList = labService.getLab(count);
        httpSession.setAttribute("count", count);
        mv.addObject("labList", labList);//查找所有用户

        httpSession.setAttribute("labList", labList);//实验室跳转预约时使用

        mv.setViewName("/WEB-INF/jsp/LRSlab");
        return mv;
    }

    @RequestMapping(value = "/LRSlabadd")//实验室列表下一页
    public ModelAndView LRSlabadd(HttpSession httpSession) {
        int count = (Integer) httpSession.getAttribute("count") + 1;
        ModelAndView mv = new ModelAndView();
        List<Lab> labList = labService.getLab(count);
        if (null == labList || labList.size() == 0) {//最尾页处理
            count = count - 1;
            List<Lab> newlabList = labService.getLab(count);
            httpSession.setAttribute("count", count);
            mv.addObject("labList", newlabList);//查找所有用户

            httpSession.setAttribute("labList", labList);//实验室跳转预约时使用

            mv.setViewName("/WEB-INF/jsp/LRSlab");
            return mv;
        }
        httpSession.setAttribute("count", count);
        mv.addObject("labList", labList);//查找所有用户

        httpSession.setAttribute("labList", labList);//实验室跳转预约时使用

        mv.setViewName("/WEB-INF/jsp/LRSlab");
        return mv;
    }

    @RequestMapping(value = "/LRSlabsub")
    public ModelAndView LRSlabsub(HttpSession httpSession) {
        if ((Integer) httpSession.getAttribute("count") == 0) {//最前页处理
            ModelAndView mv = new ModelAndView();
            int count = 0;
            List<Lab> labList = labService.getLab(count);
            httpSession.setAttribute("count", count);
            mv.addObject("labList", labList);//查找所有用户
            httpSession.setAttribute("labList", labList);//实验室跳转预约时使用
            mv.setViewName("/WEB-INF/jsp/LRSlab");
            return mv;
        }
        int count = (Integer) httpSession.getAttribute("count") - 1;
        ModelAndView mv = new ModelAndView();
        List<Lab> labList = labService.getLab(count);
        httpSession.setAttribute("count", count);
        mv.addObject("labList", labList);//查找所有用户
        httpSession.setAttribute("labList", labList);//实验室跳转预约时使用
        mv.setViewName("/WEB-INF/jsp/LRSlab");
        return mv;
    }

    @RequestMapping(value = "/LRSlabsearch")//实验室搜索框
    public ModelAndView search(HttpServletRequest request,HttpSession httpSession) {
        ModelAndView mv = new ModelAndView();
        String search = request.getParameter("search");
        if(search.equals("")){
            int count = 0;
            List<Lab> labList = labService.getLab(count);
            httpSession.setAttribute("count", count);
            mv.addObject("labList", labList);//查找所有用户
            httpSession.setAttribute("labList", labList);//实验室跳转预约时使用
            mv.setViewName("/WEB-INF/jsp/LRSlab");
            return mv;
        }
        List<Lab> labList = labService.getSearchLab(search);
        mv.addObject("labList", labList);//查找搜索用户
        httpSession.setAttribute("labList", labList);//实验室跳转预约时使用
        mv.setViewName("/WEB-INF/jsp/LRSlabSearch");
        return mv;
    }
}



   /* @RequestMapping(value = "/add")
    public ModelAndView getALLLabadd(HttpServletRequest request){
        int count = Integer.parseInt(request.getParameter("count"))+1;
        ModelAndView mv=new ModelAndView();
        List<Lab> labList=labService.getLab(count);
        request.setAttribute("count", "count");
        mv.addObject("labList",labList);//查找所有用户
        mv.setViewName("/WEB-INF/jsp/LRSlab");
        return mv;
    }
    @RequestMapping(value = "/sub")
    public ModelAndView getALLLabsub(HttpServletRequest request){
        int count = Integer.parseInt(request.getParameter("count"))-1;
        ModelAndView mv=new ModelAndView();
        List<Lab> labList=labService.getLab(count);
        request.setAttribute("count", "count");
        mv.addObject("labList",labList);//查找所有用户
        mv.setViewName("/WEB-INF/jsp/LRSlab");
        return mv;
    }
}
*/
