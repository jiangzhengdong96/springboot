package com.neusoft.springboot1.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.springboot1.entity.*;
import com.neusoft.springboot1.service.serviceImpl.*;
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
    private UserServiceImpl userService;
    @Autowired
    private TypeServiceImpl typeService;
    @Autowired
    private GoodsServiceImpl goodsService;
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private CommentServiceImpl commentService;
    @Autowired
    private ShopcarServiceImpl shopecarService;
    @Autowired
    private OrderGoodsServiceImpl orderGoodsService;
    @Autowired
    private CollectServiceImpl collectService;
    ////////////////////////////////User
    @GetMapping("/user")
    public String getAllUser(Model model,
                             @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                             @RequestParam(defaultValue="6",value="pageSize")Integer pageSize){
        if(pageNum==null || pageNum<=0){
            pageNum = 1;
        }
        //设置默认每页显示的数据数
        if(pageSize == null){
            pageSize = 1;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userService.getAllUser();
        PageInfo<User> pageInfo = new PageInfo<User>(users,pageSize);
        //4.使用model传参数回前端
        model.addAttribute("pageInfo",pageInfo);
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
    public String getAllType(Model model,
                             @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                             @RequestParam(defaultValue="10",value="pageSize")Integer pageSize){
        if(pageNum==null || pageNum<=0){
            pageNum = 1;
        }
        //设置默认每页显示的数据数
        if(pageSize == null){
            pageSize = 1;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Type> types = typeService.getAllType();
        PageInfo<Type> pageInfo = new PageInfo<Type>(types,pageSize);
        //4.使用model传参数回前端
        model.addAttribute("pageInfo",pageInfo);
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
    public String getAllGoods(Model model,
                              @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                              @RequestParam(defaultValue="6",value="pageSize")Integer pageSize){
        if(pageNum==null || pageNum<=0){
            pageNum = 1;
        }
        //设置默认每页显示的数据数
        if(pageSize == null){
            pageSize = 1;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> goods = goodsService.getAllGoods();
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(goods,pageSize);
        //4.使用model传参数回前端
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("goodslist",goods);
        return "admin/goodslist";
    }
    @RequestMapping(value = "/goodsStatusChange",method=RequestMethod.POST)
    @ResponseBody
    public void updateGoodStatus(@RequestParam("gId") Integer gId,@RequestParam("gStatus") Integer gStatus){
        if(gStatus==1){
            goodsService.updateGoodupStatus(0,gId);
            goodsService.updateGoodStatus(0,gId);
        }else if (gStatus==0){
            goodsService.updateGoodStatus(1,gId);
        }

    }






////////////////////////////////////order
    @GetMapping("/order")
    public String getAllOrder(Model model,
                              @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                              @RequestParam(defaultValue="10",value="pageSize")Integer pageSize){
        if(pageNum==null || pageNum<=0){
            pageNum = 1;
        }
        //设置默认每页显示的数据数
        if(pageSize == null){
            pageSize = 1;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orders = orderService.getAllOrder();
        PageInfo<Order> pageInfo = new PageInfo<Order>(orders,pageSize);
        //4.使用model传参数回前端
        model.addAttribute("pageInfo",pageInfo);
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
    public String getAllComment(Model model,
                                @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                                @RequestParam(defaultValue="10",value="pageSize")Integer pageSize){
        if(pageNum==null || pageNum<=0){
            pageNum = 1;
        }
        //设置默认每页显示的数据数
        if(pageSize == null){
            pageSize = 1;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Comment> comments = commentService.getAllComment();
        PageInfo<Comment> pageInfo = new PageInfo<Comment>(comments,pageSize);
        //4.使用model传参数回前端
        model.addAttribute("pageInfo",pageInfo);
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
//        if(pageNum==null || pageNum<=0){
//            pageNum = 1;
//        }
//        //设置默认每页显示的数据数
//        if(pageSize == null){
//            pageSize = 1;
//        }
//        PageHelper.startPage(pageNum, pageSize);
        List<Shopcar> shopcars = shopecarService.getAllShopcar();
//        PageInfo<Shopcar> pageInfo = new PageInfo<Shopcar>(shopcars,pageSize);
//        //4.使用model传参数回前端
//        model.addAttribute("pageInfo1",pageInfo);
        model.addAttribute("shopcarlist",shopcars);
        return "admin/shopcarlist";
    }

    @RequestMapping(value = "/shopcar/{uId}",method=RequestMethod.POST)
    @ResponseBody
    public List<Shopcar> getAllShopcar(Model model,@PathVariable("uId") Integer uId){
        List<Shopcar> shopcars = shopecarService.getShopcarById(uId);
        return shopcars;
    }

    @RequestMapping(value = "/shopcarStatusChange",method=RequestMethod.POST)
    @ResponseBody
    public void updateShopcarStatus(@RequestParam("sId") Integer sId,@RequestParam("status") Integer status){
        if(status==1){
            shopecarService.updateShopcarStatus(0,sId);
        }else if (status==0){
            shopecarService.updateShopcarStatus(1,sId);
        }

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
@RequestMapping(value = "/ordergoodStatusChange",method=RequestMethod.POST)
@ResponseBody
public void updateOrderGoodStatus(@RequestParam("id") Integer id,@RequestParam("status") Integer status){
    if(status==1){
        orderGoodsService.updateOrderGoodsStatus(0,id);
    }else if (status==0){
        orderGoodsService.updateOrderGoodsStatus(1,id);
    }

}

    //////////////////////////////Collect
    @GetMapping("/collect")
    public String getAllCollect(Model model,
                                @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                                @RequestParam(defaultValue="6",value="pageSize")Integer pageSize){
        if(pageNum==null || pageNum<=0){
            pageNum = 1;
        }
        //设置默认每页显示的数据数
        if(pageSize == null){
            pageSize = 1;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Collect> collects = collectService.getAllCollect();
        PageInfo<Collect> pageInfo = new PageInfo<Collect>(collects,pageSize);
        //4.使用model传参数回前端
        model.addAttribute("pageInfo",pageInfo);
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
