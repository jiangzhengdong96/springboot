package com.neusoft.springboot1.controller;

import com.neusoft.springboot1.entity.*;
import com.neusoft.springboot1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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
    @Autowired
    private ShopecarService shopecarService;
    @Autowired
    private OrderGoodsService orderGoodsService;
    @Autowired
    private CollectService collectService;
    ////////////////////////////////User
    @GetMapping("/user")
    public String getAllUser(Model model){
     List<User> users = userService.getAllUser();
     model.addAttribute("userlist",users);
     return "admin/userlist";
    }

    @RequestMapping(value = "/userStatusChange",method=RequestMethod.POST)
    @ResponseBody
    public void updateUserStatus(@RequestParam("uId") Integer uId,@RequestParam("status") Integer status){
        if(status==1){
            userService.updateUserStatus(0,uId);
        }else if (status==0){
            userService.updateUserStatus(1,uId);
        }

    }


    ///////////////////////////////////////////////type
    @GetMapping("/type")
    public String getAllType(Model model){
        List<Type> types = typeService.getAllType();
        model.addAttribute("typelist",types);
        return "admin/typelist";
    }

    @RequestMapping(value = "/typeStatusChange",method=RequestMethod.POST)
    @ResponseBody
    public void updateTypeStatus(@RequestParam("tId") Integer tId,@RequestParam("status") Integer status){
        if(status==1){
            typeService.updateTypeStatus(0,tId);
        }else if (status==0){
            typeService.updateTypeStatus(1,tId);
        }

    }

//    @DeleteMapping("/type/{tId}")
//    public String deleteType(@PathVariable("tId") Integer tId){
//       typeService.deleteTypeById(tId);
//        return "redirect:/type";
//    }

    @RequestMapping("/type/{tId}")
    public String edittype(@PathVariable("tId") Integer tId,  ModelMap model){
        Type type = typeService.getTypeById(tId);
        model.addAttribute("type",type);
        return "admin/typeedit";//因为admin/typeedit去到了typeedit下
    }

    @PostMapping("/typesave1")
    public String saveType1(@ModelAttribute Type type, Model model){

        if(!typeService.getTypeByName(type.gettName()).isEmpty()){
            model.addAttribute("msg","与其他类型名重复");
            return "admin/typeedit";
        }else {
            Timestamp d = new Timestamp(System.currentTimeMillis());
            type.setUpdatetime(d);
            typeService.updateType(type);
            return "redirect:/type";
        }
    }


    @RequestMapping("/typeadd")
    public String addType(ModelMap map){
        map.addAttribute("type",new Type());
        return "admin/typeadd";
    }

    /*添加完用户后重定向到list页面*/
    @PostMapping("/typesave")
    public String saveType(@ModelAttribute Type type, Model model){

        if(!typeService.getTypeByName(type.gettName()).isEmpty()){
            model.addAttribute("msg","与其他类型名重复");
            return "admin/typeadd";
        }else {
            Timestamp d = new Timestamp(System.currentTimeMillis());
            type.setAddtime(d);
            type.setUpdatetime(d);
            typeService.insertType(type);
            return "redirect:/type";
        }
    }



    //////////////////////////goods
    @GetMapping("/goods")
    public String getAllGoods(Model model){
        List<Goods> goods = goodsService.getAllGoods();
        model.addAttribute("goodslist",goods);
        return "admin/goodslist";
    }
    @RequestMapping(value = "/goodsStatusChange",method=RequestMethod.POST)
    @ResponseBody
    public void updateGoodStatus(@RequestParam("gId") Integer gId,@RequestParam("gStatus") Integer gStatus){
        if(gStatus==1){
            goodsService.updateGoodStatus(0,gId);
        }else if (gStatus==0){
            goodsService.updateGoodStatus(1,gId);
        }

    }






////////////////////////////////////order
    @GetMapping("/order")
    public String getAllOrder(Model model){
        List<Order> orders = orderService.getAllOrder();
        model.addAttribute("orderlist",orders);
        return "admin/orderlist";
    }
    @RequestMapping(value = "/orderStatusChange",method=RequestMethod.POST)
    @ResponseBody
    public void updateOrderStatus(@RequestParam("oId") Integer oId,@RequestParam("status") Integer status){
        if(status==1){
            orderService.updateOrderStatus(0,oId);
        }else if (status==0){
            orderService.updateOrderStatus(1,oId);
        }

    }



    //////////////////////////////comment
    @GetMapping("/comment")
    public String getAllComment(Model model){
        List<Comment> comments = commentService.getAllComment();
        model.addAttribute("commentlist",comments);
        return "admin/commentlist";
    }
    @RequestMapping(value = "/CommentStatusChange",method=RequestMethod.POST)
    @ResponseBody
    public void updateCommentStatus(@RequestParam("cId") Integer cId,@RequestParam("status") Integer status){
        if(status==1){
            commentService.updateCommentStatus(0,cId);
        }else if (status==0){
            commentService.updateCommentStatus(1,cId);
        }

    }






    ///////////////////////////////////shopcar
    @GetMapping("/shopcar")
    public String getAllShopcar(Model model){
        List<Shopcar> shopcars = shopecarService.getAllShopcar();
        model.addAttribute("shopcarlist",shopcars);
        return "admin/shopcarlist";
    }

    @RequestMapping(value = "/shopcar/{uId}",method=RequestMethod.POST)
    @ResponseBody
    public List<Shopcar> getAllShopcar(Model model,@PathVariable("uId") Integer uId){
        List<Shopcar> shopcars = shopecarService.getShopcarById(uId);
        return shopcars;
    }



    ///////////////////////ordergoods
    @RequestMapping(value = "/ordergoods/{oId}",method=RequestMethod.POST)
    @ResponseBody
    public List<OrderGoods> getAllOrderGoodsById(Model model,@PathVariable("oId") Integer oId){
        List<OrderGoods> orderGoods = orderGoodsService.getAllOrderGoodsById(oId);
        return orderGoods;
    }
//    @PostMapping("/userStop")
//    public void userStop(){
//        System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,");
//
//    }

    //////////////////////////////Collect
    @GetMapping("/collect")
    public String getAllCollect(Model model){
        List<Collect> collects = collectService.getAllCollect();
        model.addAttribute("collectlist",collects);
        return "admin/collectlist";
    }

    @RequestMapping(value = "/collectStatusChange",method=RequestMethod.POST)
    @ResponseBody
    public void updateCollectStatus(@RequestParam("ccId") Integer ccId,@RequestParam("status") Integer status){
        if(status==1){
            collectService.updateCollectStatus(0,ccId);
        }else if (status==0){
            collectService.updateCollectStatus(1,ccId);
        }

    }

}
