package com.Product.ProductMicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Product.ProductMicroservice.Entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

	
	 int deleteProductByProductname(String productname); 
}
