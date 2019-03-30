package com.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.lab.pojo.User;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.lab.service.UserService;

@Controller
public class UserController {
    @Resource(name = "userService")
    UserService userService;

    @RequestMapping(value = "/list")
    public ModelAndView list()
    {
        ModelAndView mv=new ModelAndView();
        List<User>  userList=userService.getUser();
        mv.addObject("userList",userList);//查找所有用户
        mv.setViewName("show");
        return mv;
    }

    @RequestMapping(value = "/updateuser")//用户自己修改信息或修改密码
    public ModelAndView updateuser(HttpServletRequest request, HttpSession httpSession){
        String oldpassword = request.getParameter("oldpassword");
        String newpassword = request.getParameter("newpassword");
        int phonenum = Integer.parseInt(request.getParameter("phonenum"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        User user = (User) httpSession.getAttribute("User");//取出用户加一个空验证
        user.setPhonenum(phonenum);
        user.setName(name);
        user.setAge(age);
        ModelAndView mv = new ModelAndView();
        if(oldpassword.equals(user.getPassword())){                        //如果旧密码符合
            if (newpassword == null || "".equals(newpassword)) {            //如果新密码为空
                httpSession.setAttribute("User", user);
                userService.update(user);
                mv.addObject("user", user);
                mv.setViewName("/WEB-INF/jsp/LRSuser");
                return mv;//返回密码不能为空
            }
            user.setPassword(newpassword);
        }
        userService.update(user);
        httpSession.setAttribute("User", user);
        mv.addObject("user", user);
        mv.setViewName("/WEB-INF/jsp/LRSuser");
        return mv;
    }

}
