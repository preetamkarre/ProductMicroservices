package com.Product.ProductMicroservice.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

public class ProductSize {
	
	@Id
	private Long sizeId;
	private String description;
	public Long getSizeId() {
		return sizeId;
	}
	public void setSizeId(Long sizeId) {
		this.sizeId = sizeId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ProductSize(Long sizeId, String description) {
		super();
		this.sizeId = sizeId;
		this.description = description;
	}
	public ProductSize() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
