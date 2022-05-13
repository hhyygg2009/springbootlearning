package com.yu.controller;

import com.yu.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hhyygg2009
 * @date Created in 2021/5/24 14:12
 */
@Controller
public class TestThymeleafController {

    @RequestMapping("/index")
    public String index(Model model) {
        Book book = new Book(
                "978-7-115-48035-4",
                66.80,
                "SSM轻量级框架应用实战",
                "人民邮电出版社",
                "肖睿 肖静 董宁（主编）",
                "48035-4.jpg"
        );
        List<Book> blackHorse = new ArrayList<Book>();
        Book b1 = new Book(
                "978-7-115-51279-6",
                56.0,
                "Spring Boot企业级开发教程",
                "人民邮电出版社",
                "黑马程序员 (作者)",
                "51279-6.jpg"
        );
        blackHorse.add(b1);
        //创建并在列表中添加第3本图书
//        Book b2 =

        //将第一本图书添加到数据模型中
        model.addAttribute("book", b1);
        model.addAttribute("books", blackHorse);
        return "index";
    }
}
