package com.teen.review.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author teen
 * @create 2021/10/8 11:34
 */
//更改路径为  /test001/user

@RequestMapping("/test001")
@Controller
public class RestStyle {

    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getPerson(@RequestParam("name") String name)
    {
        return "GET方法";
    }

    //post方法也可以通过@RequestParam来访问
//    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String postPerson(@RequestParam("name") String name , HttpServletResponse response) throws IOException {
        //必须加后缀,好像可以通过POST请求转发
            //不可以！原来是前端用的get表单
                //用原生的重定向
                    //什么玩意杂交,改回去吧
        //原生重定向会被加入 /test001，SpringBoot风格不会
        return "redirect:/ierror.html";
    }


}
