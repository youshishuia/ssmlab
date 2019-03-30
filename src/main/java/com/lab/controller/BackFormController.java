package com.lab.controller;

import com.lab.pojo.Form;
import com.lab.pojo.FormView;
import com.lab.pojo.Lab;
import com.lab.pojo.User;
import com.lab.service.FormService;
import com.lab.service.LabService;
import com.lab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class BackFormController {
    @Resource(name = "formService")
    FormService formService;
    @Resource(name = "labService")
    LabService labService;
    @Resource(name = "userService")
    UserService userService;
    @RequestMapping(value = "/BackLRSForm")//看前6个预约列表
    public ModelAndView BackLRSForm(HttpSession httpSession){
        int count = 0;
        ModelAndView mv=new ModelAndView();
        List<FormView> formViewList = formService.getFormView(count);//获得从count开始的后6个预约表
        httpSession.setAttribute("count", count);//把count存到session审核页面就能知道是第几页的预约列表（传递预约表信息到审核页面）
        httpSession.setAttribute("formViewList", formViewList);//传递预约表信息到审核页面（整个预约列表传过去）
        mv.addObject("formViewList", formViewList);//预约列表展示
        mv.setViewName("/WEB-INF/jsp/BackLRSForm");
        return mv;
    }
    @RequestMapping(value = "/BackLRSFormadd")//按预约列表下一页后跳转进这个controller
    public ModelAndView BackLRSFormadd(HttpSession httpSession) {
        int count = (Integer) httpSession.getAttribute("count") + 1;//获取下6行预约列表
        ModelAndView mv = new ModelAndView();
        List<FormView> formViewList = formService.getFormView(count);
        if (null == formViewList || formViewList.size() == 0) {//为尾页使用，取到最后一页时再按下一页就会取到一个空的预约列表（保持尾页为最后的列表）
            count = count - 1;//回到上一页
            List<FormView> newformViewList = formService.getFormView(count);
            httpSession.setAttribute("count", count);
            mv.addObject("formViewList", newformViewList);
            httpSession.setAttribute("formViewList", newformViewList);
            mv.setViewName("/WEB-INF/jsp/BackLRSForm");
            return mv;
        }//不是尾页就取下一页列表
        httpSession.setAttribute("count", count);
        mv.addObject("formViewList", formViewList);
        httpSession.setAttribute("formViewList", formViewList);
        mv.setViewName("/WEB-INF/jsp/BackLRSForm");
        return mv;
    }
    @RequestMapping(value = "/BackLRSFormsub")//按前一页时执行下面操作
    public ModelAndView LRSlabsub(HttpSession httpSession) {
        if ((Integer) httpSession.getAttribute("count") == 0) {//判断是不是最前页
            ModelAndView mv = new ModelAndView();
            int count = 0;//初始化
            List<FormView> formViewList = formService.getFormView(count);
            httpSession.setAttribute("count", count);
            mv.addObject("formViewList", formViewList);
            httpSession.setAttribute("formViewList", formViewList);
            mv.setViewName("/WEB-INF/jsp/BackLRSForm");
            return mv;
        }
        int count = (Integer) httpSession.getAttribute("count") - 1;//如果不是最前页，就获取前一页
        ModelAndView mv = new ModelAndView();
        List<FormView> formViewList = formService.getFormView(count);
        httpSession.setAttribute("count", count);
        mv.addObject("formViewList", formViewList);
        httpSession.setAttribute("formViewList", formViewList);
        mv.setViewName("/WEB-INF/jsp/BackLRSForm");
        return mv;
    }
    @RequestMapping(value = "BackLRSFormsearch")//搜索预约表视图使用
    public ModelAndView search(HttpServletRequest request, HttpSession httpSession) {
        ModelAndView mv = new ModelAndView();
        String search = request.getParameter("search");
        if(search.equals("")){//如果未输入，刷新视图
            int count = 0;
            List<FormView> formViewList = formService.getFormView(count);
            httpSession.setAttribute("count", count);
            mv.addObject("formViewList", formViewList);
            httpSession.setAttribute("formViewList", formViewList);
            mv.setViewName("/WEB-INF/jsp/BackLRSForm");
            return mv;
        }
        List<FormView> formViewList = formService.getSearchFW(search);
        mv.addObject("formViewList", formViewList);
        httpSession.setAttribute("formViewList", formViewList);
        mv.setViewName("/WEB-INF/jsp/BackLRSForm");
        return mv;
    }
    @RequestMapping(value = "/BackLRSFormEdit1")//预约列表跳转审核预约表
    public ModelAndView BackLRSFormEdit1(HttpServletRequest request,HttpSession httpSession){
        String reqUUID = request.getParameter("uuid");
        String sessUUID = (String) httpSession.getAttribute("uuid");
        httpSession.removeAttribute("uuid");
        ModelAndView mv=new ModelAndView();
        if(reqUUID.equals(sessUUID)){//防止重复提交
            int num = Integer.parseInt(request.getParameter("num"));//前端传来的第num个预约表
            List<FormView> formViewList = (List<FormView>) httpSession.getAttribute("formViewList");
            FormView formView = formViewList.get(num);
            mv.addObject("formView", formView);
            mv.setViewName("/WEB-INF/jsp/BackLRSFormEdit");
            return mv;
        }
        else {
            FormView formView =null;//重复提交就初始化
            mv.addObject("formView", formView);
            httpSession.removeAttribute("formViewList");
            mv.setViewName("/WEB-INF/jsp/BackLRSFormEdit");
            return mv;
        }
    }
    @RequestMapping(value = "/BackLRSFormEdit")//导航栏跳转预约详情
    public ModelAndView BackLRSFormEdit(HttpServletRequest request,HttpSession httpSession){
        FormView formView =null;//重复提交就初始化
        ModelAndView mv=new ModelAndView();
        mv.addObject("formView", formView);
        httpSession.removeAttribute("formViewList");
        mv.setViewName("/WEB-INF/jsp/BackLRSFormEdit");
        return mv;
    }
    @RequestMapping(value = "/Backformcancer")//删除预约
    public String Backformcancer(HttpServletRequest request,HttpSession httpSession){
        int num = Integer.parseInt(request.getParameter("num"));
        ModelAndView mv=new ModelAndView();
        List<FormView> oldformViewList = (List<FormView>) httpSession.getAttribute("formViewList");
        FormView fw = oldformViewList.get(num);
        int formid =fw.getFormid();//取出第num个预约的formid值
        int b =formService.cancer(formid);//取消第num个预约
        return "redirect:BackLRSForm";
    }
    @RequestMapping(value = "/BackLRSHelp")//导航栏跳转帮助预约表
    public ModelAndView BackLRSHelp(HttpServletRequest request,HttpSession httpSession) {
        FormView formView =null;//重复提交就初始化
        ModelAndView mv=new ModelAndView();
        mv.addObject("formView", formView);
        mv.setViewName("/WEB-INF/jsp/BackLRSHelp");
        return mv;
    }
    @RequestMapping(value = "/Backcreatform")
    public ModelAndView creatform(HttpServletRequest request, HttpSession httpSession) {
        String username = request.getParameter("username");
        String labname = request.getParameter("labname");
        String address = request.getParameter("address");
        String ap = request.getParameter("appointment");
        String apd = request.getParameter("appointmentend");//判断传入参数是否为空
        ModelAndView mv = new ModelAndView();
        if(labname == null || labname.equals("")||username == null || username.equals("")||address == null || address.equals("")||ap == null || ap.equals("")||apd == null || apd.equals("")){
            //需要输入所有参数才能申请预约
            mv.setViewName("/WEB-INF/jsp/BackLRSHelp");
            return mv;
        }
        Timestamp appointment = Timestamp.valueOf(ap);
        Timestamp appointmentend = Timestamp.valueOf(apd);//要查错捕获异常
        Lab lab = labService.getLab(labname);
        Lab newlab = labService.getLabByAddress(address);
        //if (lab.equals(newlab)){
        //mv.setViewName("/WEB-INF/jsp/LRSreservationinfo");//实验室地址和名字不匹配 暂留写错误处理或者提示
        //return mv;
        //}//对实验室名和地址做判断，看看是不是同一个实验室

        int labid = lab.getId();
        User user = userService.getUser(username);//要判断是否有用户
        int userid = user.getId();
        Form form = new Form(userid,labid,appointment,appointmentend);
        int a =formService.reservation(form);//成功预约返回1
        mv.setViewName("/WEB-INF/jsp/BackLRSHelp");
        return mv;
    }
}
