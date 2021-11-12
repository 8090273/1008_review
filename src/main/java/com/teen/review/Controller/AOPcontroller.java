package com.teen.review.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author teen
 * @create 2021/10/23 9:54
 */
@RestController
@RequestMapping("/aopController")
public class AOPcontroller {

    @GetMapping("/sayHello")
    public String sayHello(String name)
    {
        System.out.println("sayHello执行");
        return "你好哈" + name;
    }
}
