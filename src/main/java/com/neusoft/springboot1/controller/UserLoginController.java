package com.neusoft.springboot1.controller;

import com.neusoft.springboot1.entity.User;
import com.neusoft.springboot1.service.MailService;
import com.neusoft.springboot1.service.UserService;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

@Controller
public class UserLoginController {
    @Autowired
    private MailService mailService;
    @Autowired
    private UserService userService;
    @Autowired
    StringEncryptor stringEncryptor;

    @RequestMapping("/signin")
    public String Signin(ModelMap map){
        map.addAttribute("user",new User());
        return "userpage/signin";
    }

    @PostMapping("/usersave")
    public String saveUser(@ModelAttribute User user, Model model,
                           HttpServletRequest request,
                           @RequestParam("vailcode") String vailcode){
//        System.out.println("input"+vailcode);
//        System.out.println("session"+request.getSession().getAttribute("verifyCode"));
        if(!request.getSession().getAttribute("verifyCode").equals(vailcode)){
            model.addAttribute("msg","验证码错误");
            return "userpage/signin";
        }else{
            if(!userService.getUserByuName(user.getuName()).isEmpty()){
                model.addAttribute("msg1","用户名重复");
                return "userpage/signin";
            }else {
                String pwd = stringEncryptor.encrypt(user.getPassword());
                user.setPassword(pwd);
                Timestamp d = new Timestamp(System.currentTimeMillis());
                user.setAddtime(d);
                userService.insertUser(user);
                return "redirect:/pageone";
            }
        }

    }
//    2873299478@qq.com
    @PostMapping("/sendemail")
    @ResponseBody
    public void sendTemplateMail(@RequestParam("email") String email,
                                   HttpSession session) {
        //发送邮件
        String verifyCode ="123456";
        mailService.sendMail(email,"用户注册验证码",verifyCode);
        session.setAttribute("verifyCode",verifyCode);
    }


}
