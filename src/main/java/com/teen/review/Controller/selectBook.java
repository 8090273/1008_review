package com.teen.review.Controller;

import com.teen.review.Bean.tBook;
import com.teen.review.Mapper.UserBookMapper;
import com.teen.review.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author teen
 * @create 2021/10/24 0:19
 */
@Controller
public class selectBook {
    @Autowired
    BookService bookService;

    @Autowired
    UserBookMapper userBookMapper;

    @ResponseBody
    @PostMapping("/select")
//    前端传过来的是 {"page"=1} 带大括号，springboot解析不了
    public List selectBook(@RequestParam("page") int page){

        System.out.println(page);
        List<tBook> list = userBookMapper.SelectBookPage(page * 5 - 5, 5);

        return list;
    }

    @GetMapping("/selectCont")
    @ResponseBody
    public long selectCont(){
        return bookService.count();
    }
}
