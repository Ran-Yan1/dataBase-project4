package com.database.bookstore.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.database.bookstore.entity.User;
import com.database.bookstore.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author RanYan&&ChenPan
 * @since 2023-02-10
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private IUserService userService;


    /**
     * 注册用户
     * @param uname
     * @param upassword
     * @param mail
     * @return
     */
    @PostMapping(path = "/register")
    public String register(@RequestParam("uname") String uname,
                           @RequestParam("upassword") String upassword,
                           @RequestParam("mail") String mail){
        //用户在前台输入邮箱后，点击获取验证码，前端发起/getCheckCode请求，后端返回验证码；
        //前端验证验证码是否正确，若正确则提示用户输入密码，用户名等，前端将这些信息发送至后端。
        //先查询该邮箱是否已经注册过
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("mail",mail);
        if(userService.getOne(queryWrapper)!=null){
            return "该邮箱已经注册过，请登录";
        }else{
            User user=new User();
            user.setUname(uname);
            user.setPassword(upassword);
            user.setMail(mail);
            userService.save(user);
            return "注册成功！";
        }
    }


    /**
     * 登录验证
     * @param loginuser
     * @return
     */
    @PostMapping(path = "/login")
    public Object login(@RequestBody User loginuser){
        //用户输入邮箱和密码
        System.out.println(loginuser.toString());
        String mail=loginuser.getMail();
        String upassword=loginuser.getPassword();
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("mail",mail);
        User user=userService.getOne(queryWrapper);
        if(user.getPassword().equals(upassword)){
            return user;
        }else{
            return "wrong";
        }
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    @PostMapping(path = "/changePassword")
    public String changePassword(@RequestBody User user){
        //用户直接输入新密码
        Integer uid=user.getUid();
        String newPassword=user.getPassword();
        //通过id获得对应的user
        User getuser=userService.getById(uid);
        getuser.setPassword(newPassword);
        userService.updateById(getuser);
        return "修改成功";
    }


    /**
     * 找回密码
     * @return
     */
    @PostMapping(path = "/findPassword")
    public String deleteEmployee(@RequestBody User user){
        //在数据库中找到该用户
        //用户输入邮箱
        String mail=user.getMail();
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("mail",mail);
        return userService.getOne(queryWrapper).getPassword();
    }
}

