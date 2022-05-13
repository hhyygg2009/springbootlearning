package com.yu.controller;

import com.yu.pojo.Freshman;
import com.yu.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	Freshman freshman;

	@Autowired
	Person person;

	@GetMapping("/hello")
	public String hello() {
		System.out.println("123");
		return  person.toString();
//		return freshman.toString();
//		return "hello hhyygg";
	}
}
