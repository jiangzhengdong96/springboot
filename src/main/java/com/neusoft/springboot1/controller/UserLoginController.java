package com.neusoft.springboot1.controller;

import com.neusoft.springboot1.entity.User;
import com.neusoft.springboot1.service.MailService;
import com.neusoft.springboot1.service.UserService;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Map;
import java.util.Random;

@Controller
//@RequestMapping("/UserIndex")
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
    @RequestMapping("/findback")
    public String FindBack(ModelMap map){
        map.addAttribute("user",new User());
        return "userpage/findback";
    }
    @PostMapping("/findpassword")
    public String FindPassword(@ModelAttribute User user, Model model,
                           HttpServletRequest request,
                           @RequestParam("vailcode") String vailcode){
//        System.out.println("input"+vailcode);
//        System.out.println("session"+request.getSession().getAttribute("verifyCode"));
        if(!request.getSession().getAttribute("verifyCode").equals(vailcode)){
            model.addAttribute("msg","验证码错误");
            return "userpage/findback";
        }else{
            if(userService.getUserByuName(user.getuName()) == null){
                model.addAttribute("msg1","没有该用户");
                return "userpage/findback";
            }else {
                if(!userService.getUserByuName(user.getuName()).getEmail().equals(user.getEmail())){
                    model.addAttribute("msg2","该用户邮箱不正确");
                    return "userpage/findback";
                }else {
                    String pwd = stringEncryptor.encrypt(user.getPassword());
                    user.setPassword(pwd);
//                    Timestamp d = new Timestamp(System.currentTimeMillis());
//                    user.setAddtime(d);
                    userService.updateUserPassword(user);
                    return "redirect:pageone";
                }
            }
        }

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
            if(userService.getUserByuName(user.getuName()) != null){
                model.addAttribute("msg1","用户名重复");
                return "userpage/signin";
            }else {
                String pwd = stringEncryptor.encrypt(user.getPassword());
                user.setPassword(pwd);
                Timestamp d = new Timestamp(System.currentTimeMillis());
                user.setAddtime(d);
                userService.insertUser(user);
                return "redirect:pageone";
            }
        }

    }
//    2873299478@qq.com
    @PostMapping("/sendemail")
    @ResponseBody
    public void sendTemplateMail(@RequestParam("email") String email,
                                   HttpSession session) {
        //发送邮件
        String verifyCode =getRandomNickname(6);
        System.out.println(verifyCode);
        mailService.sendMail(email,"用户注册验证码",verifyCode);
        session.setAttribute("verifyCode",verifyCode);
    }


    //生成随机n位数
    public static String getRandomNickname(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++)
        {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }



    @PostMapping(value = "/userlogin")
//    @RequestMapping(value ="user/login",method = RequestMethod.POST)
    public String login(@RequestParam("uName") String uName,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){

        if(!StringUtils.isEmpty(userService.getUserByuName(uName))){
            User user = userService.getUserByuName(uName);
//        System.out.println(manager.getmName());
            if(user.getStatus().equals(1)){
                String password1 = stringEncryptor.decrypt(user.getPassword());
                if(!StringUtils.isEmpty(user.getuName()) && password1.equals(password)){
                    //登陆成功,防止表单重复提交，可以重定向主页
                    session.setAttribute("uId",user.getuId());
                    session.setAttribute("uName",user.getuName());

                    session.setAttribute("msg","登录成功！");
                    return "redirect:pageone";
                }else {
                    session.setAttribute("msg","登录失败，用户密码错误！");
                    return "redirect:pageone";
                }
            }else{
                session.setAttribute("msg","登录失败，该用户被禁用！");
                return "redirect:pageone";
            }
        }else {
                session.setAttribute("msg","登录失败，用户名不存在！");
                return "redirect:pageone";

        }


    }

    @RequestMapping(value = "/userlogout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(null != session.getAttribute("uName")){
//            String username = (String) session.getAttribute("loginUser");
            session.invalidate();
        }
        return "redirect:pageone";
    }


    @PostMapping(value = "/changepassword")
//    @RequestMapping(value ="user/login",method = RequestMethod.POST)
    public String changepassword(
                        @RequestParam("password") String password,
                        @RequestParam("oldpassword") String oldpassword,
                         @RequestParam("reoldpassword") String reoldpassword,
                        Map<String,Object> map, HttpSession session){
        User user = userService.getUserById((Integer) session.getAttribute("uId"));
        System.out.println(user);
        System.out.println(oldpassword.length());
        if(oldpassword.length() >= 4 && reoldpassword.length() >= 4 ){
            if(oldpassword.equals(reoldpassword)){
                String password1 = stringEncryptor.decrypt(user.getPassword());
                if(password1.equals(password)){
                    userService.updateUserPasswordById(stringEncryptor.encrypt(oldpassword),user.getuId());
                    session.setAttribute("msg","密码修改成功！");
                    return "redirect:pageone";
                }else {
                    session.setAttribute("msg","修改失败，旧密码输入错误！");
                    return "redirect:pageone";
                }
            }else {
                session.setAttribute("msg","修改失败，确认新密码与新密码不相同！");
                return "redirect:pageone";
            }
        }else{
            session.setAttribute("msg","修改失败，密码长度不得小于4位！");
            return "redirect:pageone";
        }

    }

}
