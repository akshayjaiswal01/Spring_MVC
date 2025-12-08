package com.demo.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.demo.beans.Product;
import com.demo.dto.ProductDto;

public class ProductDtoMapper 
{

	public static ProductDto mapProductToProductDto(Product prod) 
	{
		return new ProductDto(prod.getPid(), prod.getPname(), prod.getQty(), prod.getPrice(), prod.getMfgdate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}

	public static Product mapProductDtoToProduct(ProductDto p) 
	{
		return new Product(p.getPid(), p.getPname(), p.getQty(), p.getPrice(), LocalDate.parse(p.getMfgdate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}

}
