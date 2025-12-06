package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.MyUser;
import com.demo.beans.Product;
import com.demo.service.ProductServiceI;

@Controller
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	ProductServiceI pservice;
	
	@GetMapping("/showProduct")
	public ModelAndView showAllProducts(HttpSession session)
	{
		MyUser user = (MyUser) session.getAttribute("user");
		
		if(user != null && user.getRole().equals("admin"))
		{
			List<Product> plist = pservice.showAllProducts();
			
			return new ModelAndView("showproduct", "plist", plist); 
		}
		else
		{
			return new ModelAndView("loginpage", "message", "please provid credentials");
		}
	}
	
	@GetMapping("/addProduct")
	public String showProductForm(Model model)
	{
		model.addAttribute("p1", new Product());
		return "insertProduct";
	}
	
	@PostMapping("/insertProduct")
	public ModelAndView insertProduct(@ModelAttribute Product p)
	{
		System.out.println(p);
		boolean status = pservice.addProduct(p);
		return new ModelAndView("redirect:/product/showProduct");
	}
	
	@GetMapping("/editproduct/{pid}")
	public ModelAndView editProduct(@PathVariable("pid") int pid)
	{
		Product p = pservice.getById(pid);
		if(p != null)
		{
			return new ModelAndView("editproduct", "prod", p);
		}
		else
		{
			return new ModelAndView("redirect:/product/showProduct");
		}
	}
	
	@PostMapping("/updateProduct")
	public ModelAndView updateProduct(@ModelAttribute Product p)
	{
		System.out.println(p);
		
		boolean status = pservice.updateProduct(p);
		
		return new ModelAndView("redirect:/product/showProduct");
	}
	
	@GetMapping("/deleteproduct/{pid}")
	public ModelAndView deleteProduct(@PathVariable int pid)
	{
		boolean status = pservice.deleteProduct(pid);
		
		return new ModelAndView("redirect:/product/showProduct");
		
	}
	
	
}
