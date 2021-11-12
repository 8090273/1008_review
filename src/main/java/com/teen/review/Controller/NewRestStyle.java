package com.teen.review.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.teen.review.Bean.player;
import com.teen.review.Mapper.UserMapper;
import com.teen.review.service.UserService;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author teen
 * @create 2021/10/8 15:36
 */

//必须是RestController，不能用Controller
//@RestController
@Controller
public class NewRestStyle {

    //取出容器中的userService
    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    /*若两个controller路径相同，直接报错
    @GetMapping("/user")
    public String getPerson(@RequestParam("name") String name)
    {

        return "NewGet-" + name;
    }*/



    //你可以退下了，让位给数据库吧!
    /*@GetMapping("/user/{id}")
    public String getUserId(@PathVariable("id") Integer Id)
    {
        return "userId：" + Id;
    }*/


    //@RequestBody返回所有表单内容,只能有一个
    @ResponseBody
    @PostMapping("/player")
    public Map requestBodyTest(@RequestBody String player)
    {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("player",player);
        return map;

    }

    //测试json自动转换
    @ResponseBody
    @PostMapping("/player2")
    public player requestBodyTest02(player player02)
    {
        System.out.println(player02);
        System.out.println("master主线改回去了");
        return player02;

    }

    //可以直接封装成对象，太强了
    @PostMapping("/attack")
    public Integer requestBodyTest(player player01)
    {
        return player01.getHP() - player01.getAttack();

    }

    //接收AJAX试试 必须用@ResponseBody
    @ResponseBody
    @GetMapping("/reHP")
    public String AJAXTest(@RequestParam("username") String username)
    {
        System.out.println(username);
        //浏览器发送的AJAX请求，后端数据不会回显，会存入响应体中
        return username;
    }

    /*
    这个方法行不通。。。。
    //访问logIn可以转发到/logUser
    @PostMapping("/logIn")
    public String logIn(){

        return "logUser";
    }
*/

    //使用了@RestController后不可以再实现springBoot风格的请求转发和重定向
    //使用原生的重定向

   /* //测试能不能不使用模板引擎跳转页面
   不能。。。。。。
    @GetMapping("/test")
    public String Test()
    {
        return "ierror.html";
    }
*/


    //请求和响应AJAX，将用户登录信息给服务器
    @GetMapping("/logIn")
    public void logIn(HttpServletRequest request , HttpServletResponse response)throws IOException{
        //响应乱码
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        //为防止未登录，将session数据给username
        String username = (String) session.getAttribute("username");
        if(session.getAttribute("msg") == null){
            session.setAttribute("msg","请登录!");
        }
        if(username == null){
            username = "";
        }
        response.getWriter().write( username + session.getAttribute("msg"));

    }

    //post请求转发试试原生重定向吧|||成功了，哎。
    @PostMapping("/logUser")
    public String logUser(@RequestParam(value = "username",defaultValue = "请登录！") String username,
                      @RequestParam(value = "password",defaultValue = "请登录！") String password,
                      HttpServletResponse response,
                      HttpSession session) throws IOException {
        //解决响应乱码
        response.setContentType("text/html;charset=UTF-8");


        //重构登录逻辑
        QueryWrapper wrapper = new QueryWrapper();
        //查询用户名对应的记录
        wrapper.eq("username",username);
        Map userMap = userService.getMap(wrapper);
        //如果查到
        if (userMap != null)
        {
            //比较密码
            if (password.equals(userMap.get("password"))){
                //将用户信息存入session中
                session.setAttribute("username",username);
                //清空未登录信息
                session.setAttribute("msg","");
//                System.out.println("session是:" + session.getAttribute("username"));
//            response.getWriter().write("用户名：" + username);
//            response.sendRedirect("user.html");
                return "redirect:/user.html";
            }
            else {
                session.setAttribute("msg", "密码错误！");
//            response.getWriter().write("请登录！");
                System.out.println("登录失败");
//            response.sendRedirect("ierror.html");
                return "redirect:/ierror.html";
            }
        }
        else{
            session.setAttribute("msg","用户不存在！");
//            response.getWriter().write("请登录！");
            System.out.println("登录失败");
//            response.sendRedirect("ierror.html");
            return "redirect:/ierror.html";
        }

    }


    //上传头像功能
    @PostMapping("/upload")
    public void upload(@RequestParam("photo") MultipartFile headerImg,
                       HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        if (!headerImg.isEmpty()){
            //获取文件名
            String originalFilename = headerImg.getOriginalFilename();
            //文件名存入session中以便浏览器取出
            HttpSession session = request.getSession();
            session.setAttribute("headerImgName",originalFilename);

            //文件上传到服务器
            headerImg.transferTo(new File("F:\\JavaProject\\1008_review\\src\\main\\resources\\static\\img\\" + originalFilename));
            response.sendRedirect("user.html");
            return;
        }
        response.sendRedirect("ierror.html");
    }


    //如果上传了头像，将默认头像改为上传头像
    @GetMapping("/headerImg")
    public void headerImg(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //每次都要解决响应乱码，烦死了
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String headerImgName = (String) session.getAttribute("headerImgName");
        if (headerImgName==null)
        {
            System.out.println("session中没有文件");
            response.getWriter().write("-1");
        }
        else {
            System.out.println("session中的文件已发送");
            response.getWriter().write(headerImgName);
        }

    }


}
