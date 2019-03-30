package com.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.lab.pojo.User;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


import com.lab.service.UserService;

@Controller
//@RequestMapping(value = "/login")
public class LoginController {
    @Resource(name = "userService")
    UserService userService;

    /**
     * 存储校验不通过时给用户的错误提示信息
     */

    private Map<String, String> errors = new HashMap<String, String>();
    public Map<String, String> getErrors() {
        return errors;
    }
    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
    /*
     * 方法负责校验表单输入项
     * 表单输入项校验规则：
     *         private String userName; 用户名不能为空，并且要是3-8的字母 abcdABcd
     *         private String userPwd; 密码不能为空，并且要是3-8的数字
     */
    @RequestMapping(value = "/login1")
    public ModelAndView login(HttpServletRequest request, HttpSession httpSession)
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ModelAndView mv=new ModelAndView();
            User user = userService.loginUser(username,password);//将用户名和密码与数据库中的用户名密码做比较，如果正确就返回用户
            if(user!=null) {
                mv.addObject("user", user);
                httpSession.setAttribute("User",user);
                mv.setViewName("/WEB-INF/jsp/LRSindex");
                return mv;
            }
            errors.put("user", "登录失败，请检查用户名与密码是否输入错误");
            mv.addObject("errors",errors);
            mv.setViewName("/WEB-INF/jsp/loginfail");
            return mv;
        }
    }