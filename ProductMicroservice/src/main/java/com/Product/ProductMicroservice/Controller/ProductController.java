package com.Product.ProductMicroservice.Controller;


//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Product.ProductMicroservice.Entity.Product;
import com.Product.ProductMicroservice.Repository.ProductRepository;

import com.Product.ProductMicroservice.dto.ProductRequest;


@RestController
public class ProductController {
	
	
@Autowired
private ProductRepository productrepository;

/*
@Autowired
private ProductSizeRepository rep; */
@CachePut(cacheNames = "product", key="#id")
     @PostMapping("/productaddon")
    public Product placeOrder(@Valid @RequestBody ProductRequest request){
		return productrepository.save(request.getProduct());
       
    }
    

    @GetMapping("/findAllProducts")
    public List<Product> findAllOrders(){
        return productrepository.findAll();
    }
    
    @Cacheable(cacheNames = "product", key="#id")
    @GetMapping("/findbyid/{id}")
    public EntityModel<Optional<Product>> findByone(@PathVariable Long id) {
    	 Optional<Product> product=productrepository.findById(id);
    	 if(product == null) {
 			throw new UserNotFoundException("id"+id);
 		}
    	 EntityModel<Optional<Product>> model=EntityModel.of(product);
 		WebMvcLinkBuilder lot= linkTo(methodOn(this.getClass()).findAllOrders());
 		model.add(lot.withRel("all-products"));
		return model;
    	
    	
    	//return productrepository.findById(id);
    }
  
    @Transactional
    @DeleteMapping("/byname/{productname}")
    public int deleteByName(@PathVariable String productname) {
    	return productrepository.deleteProductByProductname(productname);
    }
    
    @Transactional
    @CacheEvict(cacheNames = "product", key="#id")
    @DeleteMapping("/byId/{id}")
    public void deleteById(@PathVariable Long id) {
    	productrepository.deleteById(id);
    	
    }
    /*User user	=service.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id"+id);
		}
		EntityModel<User> model=EntityModel.of(user);
		WebMvcLinkBuilder lot= linkTo(methodOn(this.getClass()).retrieveAll());
		model.add(lot.withRel("all-users"));
	
     */
    
}
