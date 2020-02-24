package com.neusoft.springboot1.controller;

import com.neusoft.springboot1.entity.Manager;
import com.neusoft.springboot1.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private ManagerService managerService;
    @PostMapping(value = "/login")
//    @RequestMapping(value ="user/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        Manager manager = managerService.managerLogin(username);
//        System.out.println(manager.getmName());
        if(!StringUtils.isEmpty(manager)){
            if(!StringUtils.isEmpty(manager.getmName()) && manager.getPassword().equals(password)){
                //登陆成功,防止表单重复提交，可以重定向主页
                session.setAttribute("loginUser",username);
                return "redirect:/main.html";
            }else {
                map.put("msg","用户名密码错误");
                return "login";
            }
        }else {
            map.put("msg","用户不存在");
            return "login";
        }
    }

//    @RequestMapping(value = "/logout")
//    public String logout(HttpServletRequest request){
//        HttpSession session = request.getSession();
//        if(null != session){
//           Manager manager = (Manager) session.getAttribute("loginUser");
//            session.invalidate();
//        }
//        return "login";
//    }

}
