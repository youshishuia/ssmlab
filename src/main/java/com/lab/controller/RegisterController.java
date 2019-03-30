package com.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.lab.pojo.User;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


import com.lab.service.UserService;

@Controller
//@RequestMapping(value = "/register")
public class RegisterController {
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
    @RequestMapping(value = "/register1")
    public ModelAndView register(HttpServletRequest request)
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isOk = true;
        ModelAndView mv=new ModelAndView();
        if (username == null || username.trim().equals("")) {
            isOk = false;
            errors.put("userName", "用户名不能为空！！");
        } else {
            if (!username.matches("[a-zA-Z]{3,8}")) {
                isOk = false;
                errors.put("userName", "用户名必须是3-8位的字母！！");
            }
        }
        if (password == null || password.trim().equals("")) {
            isOk = false;
            errors.put("userPwd", "密码不能为空！！");
        } else {
            if (!password.matches("\\d{3,8}")) {
                isOk = false;
                errors.put("userPwd", "密码必须是3-8位的数字！！");
            }
        }
        if(isOk){
            User user = new User(username,password);//通过格式验证后创建一个用户
            User newuser = userService.registerUser(user);//将刚创建的用户与数据库中的用户做比较，如果不存在就注册一个新用户
            if(newuser!=null) {
                mv.addObject("newuser", newuser);
                mv.setViewName("index");
                return mv;
            }
            request.setAttribute("message", "此用户名已存在");
            mv.setViewName("/WEB-INF/jsp/registerfail2");
            return mv;
        }
        mv.addObject("errors",errors);
        mv.setViewName("/WEB-INF/jsp/registerfail");
        return mv;
    }

}