package com.demo.service;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dto.ProductDto;

public interface ProductServiceI {

	List<ProductDto> showAllProducts();

	boolean addProduct(ProductDto p);

	ProductDto getById(int pid);

	boolean updateProduct(ProductDto p);

	boolean deleteProduct(int pid);

	

}
