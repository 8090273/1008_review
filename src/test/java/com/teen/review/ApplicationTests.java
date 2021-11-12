package com.teen.review;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.teen.review.Bean.tUser;
import com.teen.review.Mapper.UserBookMapper;
import com.teen.review.Mapper.UserMapper;
import com.teen.review.service.BookService;
import com.teen.review.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

//Test依赖一直出错是因为导入了很多Test（如Juint4）删掉就行
@SpringBootTest
class ApplicationTests {
    @Autowired
    UserBookMapper userBookMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Test
    void contextLoads() {
    }

    @Test
    void UserMapper()
    {
        tUser tUser = userMapper.selectById(1);

        System.out.println(tUser);
    }

    @Test
    void SelectByUserNameTest(){
        String username = "809027";

        //创建条件构造器Warpper
        QueryWrapper wrapper = new QueryWrapper();
        //附加条件 .eq 字段相等
        wrapper.eq("username",username);
        Map map = userService.getMap(wrapper);

        if( map==null){
            System.out.println("没查到");
        }
    }

    @Test
    void MybatisTest01()
    {
        System.out.println(userMapper.getUserById(1));
        //查询结果
        // tUser{id=1, username='admin', password='admin', email='admin@atguigu.com', headerImgPath='null', books=null}
    }

    @Test
    void MybatisTest03(){
        System.out.println(userBookMapper.SelectBookByUser("admin"));
    }
    @Test
    void MybatisTest04(){
        System.out.println(userMapper.getUserBookById(1));
        /*
        tUser{
            id=null,
            username='admin',
            password='null',
            email='null',
            headerImgPath='null',
            books=[
                tBook{id=0, name='数据结构与算法', author='null', price=0.0, sales=0, stock=0, imgPath='null'},
                tBook{id=0, name='怎样拐跑别人的媳妇', author='null', price=0.0, sales=0, stock=0, imgPath='null'},
                tBook{id=0, name='木虚肉盖饭', author='null', price=0.0, sales=0, stock=0, imgPath='null'},
                tBook{id=0, name='C++编程思想', author='null', price=0.0, sales=0, stock=0, imgPath='null'},
                tBook{id=0, name='C语言程序设计', author='null', price=0.0, sales=0, stock=0, imgPath='null'},
                tBook{id=0, name='UNIX高级环境编程', author='null', price=0.0, sales=0, stock=0, imgPath='null'},
                tBook{id=0, name='大话设计模式', author='null', price=0.0, sales=0, stock=0, imgPath='null'}
                ]

            }
        * */
    }

    @Test
    void MybatisTest05Page(){
        System.out.println(userBookMapper.SelectBookPage(0,5));
    }


}
