package com.neusoft.springboot1.controller;

import com.neusoft.springboot1.entity.*;
import com.neusoft.springboot1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/user")
    public String getAllUser(Model model){
     List<User> users = userService.getAllUser();
     model.addAttribute("userlist",users);
     return "admin/userlist";
    }

    @GetMapping("/type")
    public String getAllType(Model model){
        List<Type> types = typeService.getAllType();
        model.addAttribute("typelist",types);
        return "admin/typelist";
    }

    @DeleteMapping("/type/{tId}")
    public String deleteType(@PathVariable("tId") Integer tId){
       typeService.deleteTypeById(tId);
        return "redirect:/type";
    }

    @RequestMapping("/typeadd")
    public String addType(ModelMap map){
        map.addAttribute("type",new Type());
        return "admin/typeadd";
    }

    /*添加完用户后重定向到list页面*/
    @PostMapping("/typesave")
    public String saveType(@ModelAttribute Type type){
        Timestamp d = new Timestamp(System.currentTimeMillis());
        type.setAddtime(d);
        typeService.insertType(type);
        return "redirect:/type";
    }

    @GetMapping("/goods")
    public String getAllGoods(Model model){
        List<Goods> goods = goodsService.getAllGoods();
        model.addAttribute("goodslist",goods);
        return "admin/goodslist";
    }

    @GetMapping("/order")
    public String getAllOrder(Model model){
        List<Order> orders = orderService.getAllOrder();
        model.addAttribute("orderlist",orders);
        return "admin/orderlist";
    }

    @GetMapping("/comment")
    public String getAllComment(Model model){
        List<Comment> comments = commentService.getAllComment();
        model.addAttribute("commentlist",comments);
        return "admin/commentlist";
    }
//    @PostMapping("/userStop")
//    public void userStop(){
//        System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,");
//
//    }
}
