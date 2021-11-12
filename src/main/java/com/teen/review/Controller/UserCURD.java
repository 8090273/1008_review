package com.teen.review.Controller;

import com.teen.review.Bean.tUser;
import com.teen.review.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author teen
 * @create 2021/10/17 11:27
 */
@RequestMapping("/user")
@Controller
public class UserCURD {

    @Autowired
    UserService userService;

    @ResponseBody
    @GetMapping("/dynamic_table")
    public String dynamicTable(Model model)
    {
        List<tUser> list = userService.list();
        model.addAttribute("users",list);
        String modelString = model.toString();
        System.out.println(modelString);

        return modelString;
    }

    @GetMapping("/select/{id}")
    public String selectById(@PathVariable(value = "id",required = false) Integer id){

        System.out.println(userService.getById(id));
        //转发到显示controller
        return "redirect:/user/dynamic_table";
    }

    @PostMapping("/register")
    public String register(tUser user) {
        userService.save(user);
        return "redirect:/index.html";
    }

}
