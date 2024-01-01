package com.project.Service;

import java.util.List;

import com.project.Model.Product;

public interface ProductService {
	
	public Product SaveProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public Product getProductById(Integer id);
	
	public String deleteProduct(Integer id);

}
