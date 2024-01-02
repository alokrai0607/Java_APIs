package com.product.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.Model.Product;
import com.product.Repository.ProductRepository;

@Service
public class productServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product SaveProduct(Product product) {

		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {

		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer id) {

		return productRepository.findById(id).get();

	}

	@Override
	public String deleteProduct(Integer id) {
		Product pro = productRepository.findById(id).get();

		if (pro != null) {
			productRepository.delete(pro);
			return ("Product Deleted Sucessfully");
		} else {
			return ("Product Not Avail");
		}

	}

}
