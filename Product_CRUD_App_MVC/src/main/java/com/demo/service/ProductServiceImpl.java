package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDaoI;

@Service
public class ProductServiceImpl implements ProductServiceI 
{

	@Autowired
	ProductDaoI pdao;
	
	@Override
	public List<Product> showAllProducts() 
	{
		return pdao.showAllProducts();
	}

	@Override
	public boolean addProduct(Product p) 
	{
		return pdao.addProduct(p);
	}

	@Override
	public Product getById(int pid) 
	{
		return pdao.getById(pid);
	}

	@Override
	public boolean updateProduct(Product p) 
	{
		return pdao.updateProduct(p);
	}

	@Override
	public boolean deleteProduct(int pid) 
	{
		return pdao.deleteProduct(pid);
	}

}
