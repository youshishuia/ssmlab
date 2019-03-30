package com.lab.controller;

import com.lab.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class BackController {
    @RequestMapping(value = "/backstage")//加一个权限验证,跳转后台，不是管理员不能跳转
    public ModelAndView index(HttpSession httpSession){
        User user = (User) httpSession.getAttribute("User");
        String permission = user.getPermission();
        ModelAndView mv = new ModelAndView();
        if (permission.equals("管理员") ) {
            mv.setViewName("/WEB-INF/jsp/BackLRSindex");
            return mv;
        }
        mv.setViewName("/WEB-INF/jsp/LRSindex");
        return mv;
    }
}
