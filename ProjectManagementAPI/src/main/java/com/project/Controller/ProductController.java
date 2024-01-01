package com.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Model.Product;
import com.project.Service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {

	@Autowired
	private ProductService proserv;

	@PostMapping("/saveProduct")
	public ResponseEntity<?> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<>(proserv.SaveProduct(product), HttpStatus.CREATED);
	}

	@GetMapping("/products")
	public ResponseEntity<?> getAllProducts() {
		return new ResponseEntity<>(proserv.getAllProduct(), HttpStatus.OK);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Integer id) {
		return new ResponseEntity<>(proserv.getProductById(id), HttpStatus.OK);
	}

	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
		return new ResponseEntity<>(proserv.deleteProduct(id), HttpStatus.OK);
	}

	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
		Product existingProduct = proserv.getProductById(id);

		if (existingProduct == null) {
			return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
		}

		// Update the fields you want to modify
		existingProduct.setProductName(product.getProductName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setStatus(product.getStatus());
		existingProduct.setPrice(product.getPrice());

		// Save the updated product
		Product updatedProduct = proserv.SaveProduct(existingProduct);

		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}
}
