package com.lab.controller;

import com.lab.pojo.Form;
import com.lab.pojo.FormView;
import com.lab.pojo.Lab;
import com.lab.pojo.User;
import com.lab.service.FormService;
import com.lab.service.LabService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class FormController {
    @Resource(name = "formService")
    FormService formService;
    @Resource(name = "labService")
    LabService labService;

    @RequestMapping(value = "/creatform")//预约实验室
    public ModelAndView creatform(HttpServletRequest request, HttpSession httpSession) {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String ap = request.getParameter("appointment");
        String apd = request.getParameter("appointmentend");//判断传入参数是否为空
        ModelAndView mv = new ModelAndView();
        if(name == null || name.equals("")||address == null || address.equals("")||ap == null || ap.equals("")||apd == null || apd.equals("")){
            //需要输入所有参数才能申请预约
            mv.setViewName("/WEB-INF/jsp/LRSreservationinfo");
            return mv;
        }
        Timestamp appointment = Timestamp.valueOf(ap);
        Timestamp appointmentend = Timestamp.valueOf(apd);//要查错捕获异常
        Lab lab = labService.getLab(name);
        Lab newlab = labService.getLabByAddress(address);
        //if (lab.equals(newlab)){
         //mv.setViewName("/WEB-INF/jsp/LRSreservationinfo");//实验室地址和名字不匹配 暂留写错误处理或者提示
         //return mv;
        //}//对实验室名和地址做判断，看看是不是同一个实验室

            int labid = lab.getId();
            User user = (User) httpSession.getAttribute("User");
            int userid = user.getId();
            Form form = new Form(userid,labid,appointment,appointmentend);
            int a =formService.reservation(form);//成功预约返回1
            mv.setViewName("/WEB-INF/jsp/LRSreservationinfo");
            return mv;
    }

    @RequestMapping(value = "/LRSreservation")//导航栏跳转预约列表
    public ModelAndView reservation(HttpSession httpSession){
        User user = (User) httpSession.getAttribute("User");
        int userid = user.getId();
        ModelAndView mv=new ModelAndView();
        List<FormView> formViewList = formService.getUserFormView(userid);
        httpSession.setAttribute("formViewList", formViewList);//实验室跳转预约时使用
        mv.addObject("formViewList", formViewList);//查找搜索用户
        mv.setViewName("/WEB-INF/jsp/LRSreservation");
        return mv;
    }
    @RequestMapping(value = "/formcancer")//取消预约
    public String formcancer(HttpServletRequest request,HttpSession httpSession){
        int num = Integer.parseInt(request.getParameter("num"));
        ModelAndView mv=new ModelAndView();
        List<FormView> oldformViewList = (List<FormView>) httpSession.getAttribute("formViewList");//实验室跳转预约时使用
        FormView fw = oldformViewList.get(num);
        int formid =fw.getFormid();//取出第num个预约的formid值
        int b =formService.cancer(formid);//取消第num个预约
       /* User user = (User) httpSession.getAttribute("User");
        int userid = user.getId();
        List<FormView> formViewList = formService.getUserFormView(userid);
        httpSession.setAttribute("formViewList", formViewList);//实验室跳转预约时使用
        mv.addObject("formViewList", formViewList);//查找搜索用户
        mv.setViewName("/WEB-INF/jsp/LRSreservation");
        return mv;
        */
       return "redirect:LRSreservation";
    }
}
