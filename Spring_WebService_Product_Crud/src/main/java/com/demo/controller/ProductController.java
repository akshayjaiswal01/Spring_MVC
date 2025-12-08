package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.Product;
import com.demo.dto.ProductDto;
import com.demo.service.ProductServiceI;

@RestController("/product")
public class ProductController 
{
	@Autowired
	ProductServiceI pservice;
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getAllproducts()
	{
		
		List<ProductDto> plist = pservice.showAllProducts();
		return ResponseEntity.ok(plist);
		
	}
	
	@GetMapping("/products/{pid}")
	public ResponseEntity<ProductDto> getById(@PathVariable int pid)
	{
		ProductDto p = pservice.getById(pid);
		if(p != null)
		{
			return ResponseEntity.ok(p);
		}
		else
		{
			return (ResponseEntity<ProductDto>) ResponseEntity.notFound();
		}
	}
	
	@PostMapping("/products/{pid}")
	public ResponseEntity<String> addProduct(@RequestBody ProductDto p)
	{
		boolean status = pservice.addProduct(p);
		if(status)
		{
			return ResponseEntity.ok("product added successfully");
		}
		else
		{
			return ResponseEntity.ok("failed to add product");
		}
	}
	
	@PutMapping("/products/{pid}")
	public ResponseEntity<String> updateProduct(@RequestBody ProductDto p)
	{
		boolean status = pservice.updateProduct(p);
		if(status)
		{
			return ResponseEntity.ok("Product updated successfully");
		}
		else
		{
			return ResponseEntity.ok("failed to update product");
		}
	}
	
	@DeleteMapping("/products/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable int pid)
	{
		boolean status = pservice.deleteProduct(pid);
		if(status)
		{
			return ResponseEntity.ok("Product delete successfully");
		}
		else
		{
			return ResponseEntity.ok("failed to delete");
		}
	}
	
}
