package com.database.bookstore.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.database.bookstore.entity.Ord;
import com.database.bookstore.service.IBookService;
import com.database.bookstore.service.IOrdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author RanYan&&ChenPan
 * @since 2023-02-10
 */
@RestController
@RequestMapping("/ord")
@CrossOrigin
public class OrdController {

    @Autowired
    private IOrdService ordService;
    @Autowired
    private IBookService bookService;

    /**
     * 根据用户id、书籍id和书籍数量生成订单
     * @param ords 含有用户id、书籍id和书籍数量的订单对象List
     * @return
     */
    @PostMapping(path = "/addOrd")
    public String addOrd(@RequestParam List<Ord> ords){
        for(int i=1;i<=ords.size();i++){
            Ord ord=ords.get(i-1);
            Ord newOrd=new Ord();
            newOrd.setUid(ord.getUid());
            newOrd.setBid(ord.getBid());
            newOrd.setBnumber(ord.getBnumber());
            newOrd.setState(0);
            newOrd.setTotalPrice((bookService.getById(ord.getBid()).getPrice())*ord.getBnumber());
            ordService.save(newOrd);
        }
        return "success";
    }

    /**
     * 根据用户id获得其所有订单
     * @param uid
     * @return
     */
    @GetMapping("/getOrds")
    public List<Ord> listOrds(@RequestParam("uid") Integer uid){
        QueryWrapper<Ord> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("uid",uid);
        return ordService.list(queryWrapper);
    }

    /**
     * 将订单改为支付状态
     * @param oid
     * @return
     */
    @PostMapping(path = "/changeOrd1")
    public String payOrd(@RequestParam("oid") Integer oid){
        Ord ord=ordService.getById(1);
        ord.setState(1);
        ordService.updateById(ord);
        return "success";
    }

    /**
     * 撤销订单
     * @param oid
     * @return
     */
    @PostMapping(path = "/deleteOrd")
    public String deleteOrd(@RequestParam("oid") Integer oid){
        ordService.removeById(oid);
        return "success";
    }
}
