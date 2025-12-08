package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDaoI {

	List<Product> showAllProducts();

	boolean addProduct(Product p);

	Product getById(int pid);

	boolean updateProduct(Product p);

	boolean deleteProduct(int pid);

}
