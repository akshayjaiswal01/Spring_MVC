package com.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController 
{
	@GetMapping("/")
	public String homepage()
	{
		return "Hello World..";
	}
	
	@GetMapping("/welcome")
	public ResponseEntity<String> syaWelcome()
	{
		return ResponseEntity.ok("Welcome to Rest web services");
	}
}
