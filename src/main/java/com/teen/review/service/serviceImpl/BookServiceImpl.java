package com.teen.review.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teen.review.Bean.tBook;
import com.teen.review.Mapper.UserBookMapper;
import com.teen.review.service.BookService;
import org.springframework.stereotype.Service;

/**
 * @author teen
 * @create 2021/10/24 0:42
 */
@Service
public class BookServiceImpl extends ServiceImpl<UserBookMapper, tBook> implements BookService {
}
