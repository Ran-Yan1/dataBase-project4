package com.database.bookstore.service.impl;

import com.database.bookstore.entity.User;
import com.database.bookstore.mapper.UserMapper;
import com.database.bookstore.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author RanYan&&ChenPan
 * @since 2023-02-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
