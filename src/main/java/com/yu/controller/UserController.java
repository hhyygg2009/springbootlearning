package com.yu.controller;

import com.yu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hhyygg2009
 * @date Created in 2021/5/24 11:18
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @PostMapping("/login")
    public String login(User user) {


        return "";
    }

    @GetMapping("/login")
    public String loginpage(Model model) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");


        model.addAttribute("currentYear", sdf.format(new Date()));
        return "login";
    }
}
