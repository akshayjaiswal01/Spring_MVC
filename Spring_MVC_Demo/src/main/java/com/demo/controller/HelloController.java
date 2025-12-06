package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController 
{
	@GetMapping("/hello")
	public String sayHello()
	{
		return "hello";
	}
	
	@GetMapping("/welcome")
	public ModelAndView sayWelcome()
	{
		String msg = "Welcome message from controller";
		return new ModelAndView("welcome", "message", msg);
	}
	
	@GetMapping("/data")
	public String myData(Model mymodel)
	{
		mymodel.addAttribute("name", "akshay");
		mymodel.addAttribute("email", "ak@gmail.com");
		return "data";
	}
}
