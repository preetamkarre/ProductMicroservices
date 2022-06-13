package com.Product.ProductMicroservice.dto;

import com.Product.ProductMicroservice.Entity.Product;

public class ProductRequest {

	
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductRequest(Product product) {
		super();
		this.product = product;
	}

	public ProductRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductRequest [product=" + product + "]";
	}
	
	
	
}
