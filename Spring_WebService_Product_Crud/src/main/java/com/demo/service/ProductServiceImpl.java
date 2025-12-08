package com.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDaoI;
import com.demo.dto.ProductDto;
import com.demo.mapper.ProductDtoMapper;

@Service
public class ProductServiceImpl implements ProductServiceI 
{

	@Autowired
	ProductDaoI pdao;
	
	public List<ProductDto> showAllProducts() 
	{
		List<Product> plist = pdao.showAllProducts();
		
		List<ProductDto> plist1 = plist.stream()
				.map(prod -> ProductDtoMapper.mapProductToProductDto(prod))
				.collect(Collectors.toList());
		
		return plist1;
	}


	public ProductDto getById(int pid) 
	{
		Product p = pdao.getById(pid);
		
		if(p != null)
		{
			ProductDto p1 = ProductDtoMapper.mapProductToProductDto(p);
			return p1;
		}
		return null;
	}
	
	@Override
	public boolean addProduct(ProductDto p) 
	{
		Product product = ProductDtoMapper.mapProductDtoToProduct(p);
		return pdao.addProduct(product);
	}

	public boolean updateProduct(ProductDto p) 
	{
		Product product = ProductDtoMapper.mapProductDtoToProduct(p);
		
		return pdao.updateProduct(product);
	}

	public boolean deleteProduct(int pid) 
	{
		return pdao.deleteProduct(pid);
	}

	

}
