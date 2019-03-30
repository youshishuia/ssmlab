package com.lab.controller;

import com.lab.pojo.User;
import com.lab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BackUserController {
    @Resource(name = "userService")
    UserService userService;
    @RequestMapping(value = "/BackLRSuserList")//分页查看所有用户
    public ModelAndView backLRSuserList(HttpSession httpSession) {
        int count = 0;
        ModelAndView mv = new ModelAndView();
        List<User> userList = userService.getListUser(count);
        httpSession.setAttribute("count", count);
        mv.addObject("userList", userList);//查找所有用户
        httpSession.setAttribute("userList", userList);//实验室跳转预约时使用
        mv.setViewName("/WEB-INF/jsp/BackLRSuserList");
        return mv;
    }
    @RequestMapping(value = "/BackLRSuserListadd")//下一页
    public ModelAndView BackLRSuserList(HttpSession httpSession) {
        int count = (Integer) httpSession.getAttribute("count") + 1;
        ModelAndView mv = new ModelAndView();
        List<User> userList = userService.getListUser(count);
        if (null == userList || userList.size() == 0) {
            count = count - 1;
            List<User> newuserList = userService.getListUser(count);
            httpSession.setAttribute("count", count);
            mv.addObject("userList", newuserList);//查找所有用户

            httpSession.setAttribute("userList", userList);//实验室跳转预约时使用

            mv.setViewName("/WEB-INF/jsp/BackLRSuserList");
            return mv;
        }
        httpSession.setAttribute("count", count);
        mv.addObject("userList", userList);//查找所有用户

        httpSession.setAttribute("userList", userList);//实验室跳转预约时使用

        mv.setViewName("/WEB-INF/jsp/BackLRSuserList");
        return mv;
    }
    @RequestMapping(value = "/BackLRSuserListsub")//上一页
    public ModelAndView BackLRSuserListsub(HttpSession httpSession) {
        if ((Integer) httpSession.getAttribute("count") == 0) {
            ModelAndView mv = new ModelAndView();
            int count = 0;
            List<User> userList = userService.getListUser(count);
            httpSession.setAttribute("count", count);
            mv.addObject("userList", userList);//查找所有用户
            httpSession.setAttribute("userList", userList);//实验室跳转预约时使用
            mv.setViewName("/WEB-INF/jsp/BackLRSuserList");
            return mv;
        }
        int count = (Integer) httpSession.getAttribute("count") - 1;
        ModelAndView mv = new ModelAndView();
        List<User> userList = userService.getListUser(count);
        httpSession.setAttribute("count", count);
        mv.addObject("userList", userList);//查找所有用户
        httpSession.setAttribute("userList", userList);//实验室跳转预约时使用
        mv.setViewName("/WEB-INF/jsp/BackLRSuserList");
        return mv;
    }
    @RequestMapping(value = "/BackLRSuserListSearch")//搜索
    public ModelAndView BackLRSuserListsearch(HttpServletRequest request, HttpSession httpSession) {
        ModelAndView mv = new ModelAndView();
        String search = request.getParameter("search");
        if(search ==""){
            int count = 0;
            List<User> userList = userService.getListUser(count);
            httpSession.setAttribute("count", count);
            mv.addObject("userList", userList);//查找所有用户
            httpSession.setAttribute("userList", userList);//实验室跳转预约时使用
            mv.setViewName("/WEB-INF/jsp/BackLRSuserList");
            return mv;
        }
        List<User> userList = userService.getSearchUser(search);
        mv.addObject("userList", userList);//查找搜索用户
        httpSession.setAttribute("userList", userList);//实验室跳转预约时使用
        mv.setViewName("/WEB-INF/jsp/BackLRSuserSearch");
        return mv;
    }
    @RequestMapping(value = "/BackLRSuserEdit1")//用户跳转修改信息时使用
    public ModelAndView BackLRSuserEdit1(HttpServletRequest request,HttpSession httpSession) {
        String reqUUID = request.getParameter("uuid");
        String sessUUID = (String) httpSession.getAttribute("uuid");
        httpSession.removeAttribute("uuid");
        ModelAndView mv = new ModelAndView();
        if (reqUUID.equals(sessUUID)) {
            int num = Integer.parseInt(request.getParameter("num"));
            List<User> userList = (List<User>) httpSession.getAttribute("userList");//用户跳转修改时使用
            User user = userList.get(num);
            mv.addObject("user", user);//通过实验室页面的预约按钮跳转到预约页面，把用户的用户名和id传过去
            mv.setViewName("/WEB-INF/jsp/BackLRSuserEdit");
            return mv;
        } else {
            User user = null;
            mv.addObject("User", user);
            httpSession.removeAttribute("userList");
            mv.setViewName("/WEB-INF/jsp/BackLRSuserEdit");
            return mv;
        }
    }
    @RequestMapping(value = "/BackLRSuserEdit")//导航栏跳转修改用户信息界面
    public ModelAndView BackLRSuserEdit(HttpSession httpSession){
        User user = null;
        ModelAndView mv=new ModelAndView();
        mv.addObject("user", user);
        mv.setViewName("/WEB-INF/jsp/BackLRSuserEdit");
        return mv;
    }
    @RequestMapping(value = "/Edit")//修改用户信息
    public ModelAndView Edit(HttpServletRequest request, HttpSession httpSession){
        String a = request.getParameter("id");
        ModelAndView mv=new ModelAndView();
        if (a == null || "".equals(a)) {//如果ID为空，初始化
            User user = null;
            mv.addObject("user", user);
            mv.setViewName("/WEB-INF/jsp/BackLRSuserEdit");
            return mv;
        }
        String username = request.getParameter("username");
        if (username == null || "".equals(username)) {//如果用户名为空，初始化
            User user = null;
            mv.addObject("user", user);
            mv.setViewName("/WEB-INF/jsp/BackLRSuserEdit");
            return mv;
        }
        int id = Integer.parseInt(a);
        String b = request.getParameter("phonenum");
        if (b == null || "".equals(b)) {
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            User user = userService.getUser(id);//通过ID找用户
            User newuser = userService.getUser(username);//通过用户名找用户
            if (user.equals(newuser)) {//如果用户名和ID匹配，就更新用户数据
                user.setId(id);
                user.setUsername(username);
                user.setPhonenum(null);
                user.setName(name);
                user.setAge(age);
                userService.update(user);
                mv.addObject("user", user);
                mv.setViewName("/WEB-INF/jsp/BackLRSuserEdit");
                return mv;
            }
        }
        int phonenum = Integer.parseInt(b);//上面已经做了非空判断
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        User user = userService.getUser(id);
        User newuser = userService.getUser(username);
        if(user.equals(newuser)){
            user.setId(id);
            user.setUsername(username);
            user.setPhonenum(phonenum);
            user.setName(name);
            user.setAge(age);
            userService.update(user);
            mv.addObject("user", user);
            mv.setViewName("/WEB-INF/jsp/BackLRSuserEdit");
            return mv;
        }
        user = null;
        mv.addObject("user", user);
        mv.setViewName("/WEB-INF/jsp/BackLRSuserEdit");
        return mv;
    }
}
