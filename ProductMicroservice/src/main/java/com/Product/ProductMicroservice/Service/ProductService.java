package com.Product.ProductMicroservice.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Product.ProductMicroservice.Controller.UserNotFoundException;
import com.Product.ProductMicroservice.Entity.Product;
import com.Product.ProductMicroservice.Repository.ProductRepository;
import com.Product.ProductMicroservice.dto.ProductRequest;

@Service
public class ProductService {

	
	
@Autowired
private ProductRepository productrepository;


     
    public Product placeOrder(ProductRequest request){
		return productrepository.save(request.getProduct());
       
    }
    

    @GetMapping("/findAllProducts")
    public List<Product> findAllOrders(){
        return productrepository.findAll();
    }
    
    
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
    
	
	
}
