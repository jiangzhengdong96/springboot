package com.neusoft.springboot1.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.springboot1.entity.Comment;
import com.neusoft.springboot1.entity.Goods;
import com.neusoft.springboot1.service.CommentService;
import com.neusoft.springboot1.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
//@RequestMapping("/UserIndex")
public class IndexController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/pageone")
    public String Index(Model model,
                        @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                        @RequestParam(defaultValue="9",value="pageSize")Integer pageSize) {
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        //设置默认每页显示的数据数
        if (pageSize == null) {
            pageSize = 1;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> goods = goodsService.getAllGoods1();
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(goods, pageSize);
        //4.使用model传参数回前端
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("goodslist", goods);

        return "userpage/pageone";
    }
    @GetMapping("/goodsinfo/{gId}")
    public String GoodsInfo( @PathVariable("gId") Integer gId,
                             Model model){
        System.out.println(gId);
        List<Comment> comments = commentService.getAllCommentsById(gId);
        System.out.println(comments);
        Goods goods = goodsService.getGoodsInfoById(gId);
        model.addAttribute("goodsinfos",goods);
        model.addAttribute("commentlist",comments);
        return "userpage/goodsinfo";
    }
}