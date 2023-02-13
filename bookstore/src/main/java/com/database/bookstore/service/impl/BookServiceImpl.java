package com.database.bookstore.service.impl;

import com.database.bookstore.entity.Book;
import com.database.bookstore.mapper.BookMapper;
import com.database.bookstore.service.IBookService;
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
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

}
