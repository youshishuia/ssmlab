package com.lab.controller;

import com.lab.pojo.Lab;
import com.lab.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PageController {

    @RequestMapping(value = "/LRSuser")
    public ModelAndView user(HttpSession httpSession){
        User user = (User) httpSession.getAttribute("User");
        ModelAndView mv=new ModelAndView();
        mv.addObject("user", user);
        mv.setViewName("/WEB-INF/jsp/LRSuser");
        return mv;
    }


   /* @RequestMapping(value = "/LRSlab")
    public ModelAndView lab(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/WEB-INF/jsp/LRSlab");
        return mv;
    }

    @RequestMapping(value = "/LRSreservation")
    public ModelAndView reservation(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/WEB-INF/jsp/LRSreservation");
        return mv;
    }
    */
    @RequestMapping(value = "/LRSreservationinfo1")//实验室跳转预约时使用
    public ModelAndView reservationinfo1(HttpServletRequest request,HttpSession httpSession){
        String reqUUID = request.getParameter("uuid");
        String sessUUID = (String) httpSession.getAttribute("uuid");
        httpSession.removeAttribute("uuid");
        ModelAndView mv=new ModelAndView();
        if(reqUUID.equals(sessUUID)){
            int num = Integer.parseInt(request.getParameter("num"));
            List<Lab> labList = (List<Lab>) httpSession.getAttribute("labList");//实验室跳转预约时使用
            Lab lab = labList.get(num);
            mv.addObject("lab", lab);//通过实验室页面的预约按钮跳转到预约页面，把实验室的名字和地址传过去
            mv.setViewName("/WEB-INF/jsp/LRSreservationinfo");
            return mv;
        }
        else {
            Lab lab =null;
            mv.addObject("lab", lab);
            httpSession.removeAttribute("labList");
            mv.setViewName("/WEB-INF/jsp/LRSreservationinfo");
            return mv;
        }

    }
    @RequestMapping(value = "/LRSreservationinfo")//导航栏跳转预约
    public ModelAndView reservationinfo(HttpServletRequest request,HttpSession httpSession){
        ModelAndView mv=new ModelAndView();
            Lab lab =null;
            mv.addObject("lab", lab);
            httpSession.removeAttribute("labList");
            mv.setViewName("/WEB-INF/jsp/LRSreservationinfo");
            return mv;
        }

    @RequestMapping(value = "/LRSindex")
    public ModelAndView index(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/WEB-INF/jsp/LRSindex");
        return mv;
    }
    @RequestMapping(value = "/index")
    public ModelAndView outindex() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
}
