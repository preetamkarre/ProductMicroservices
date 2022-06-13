package com.Product.ProductMicroservice.Entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;


@Entity
@Table(name="product")

public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long productid;
    @NotEmpty(message="Product name must not be empty")
    private String productname;
    private String description;
    private String  shortDescription;
    private Double averagePurchasePrice;
    private String purchasePriceUOM;
    @Pattern(regexp="^[a-zA-Z0-9]{3}",message="length must be 3")  
    private String departmentId;
    @Pattern(regexp="^[a-zA-Z0-9]{4}",message="length must be 4")  
    private String classId;
    @Pattern(regexp="^[a-zA-Z0-9]{4}",message="length must be 4")  
    private String subClassId;
    private Long styleId;
    private String colorId;
    private String brandId;
    private String vendorId;
    private String materialId;
    @NotEmpty
    private String sellingSeasonCode;

    
    @OneToMany(targetEntity = ProductSize.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="cp_fk",referencedColumnName = "productid")
private List<ProductSize> productsize;


	public Long getProductid() {
		return productid;
	}


	public void setProductid(Long productid) {
		this.productid = productid;
	}


	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getShortDescription() {
		return shortDescription;
	}


	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}


	public Double getAveragePurchasePrice() {
		return averagePurchasePrice;
	}


	public void setAveragePurchasePrice(Double averagePurchasePrice) {
		this.averagePurchasePrice = averagePurchasePrice;
	}


	public String getPurchasePriceUOM() {
		return purchasePriceUOM;
	}


	public void setPurchasePriceUOM(String purchasePriceUOM) {
		this.purchasePriceUOM = purchasePriceUOM;
	}


	public String getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}


	public String getClassId() {
		return classId;
	}


	public void setClassId(String classId) {
		this.classId = classId;
	}


	public String getSubClassId() {
		return subClassId;
	}


	public void setSubClassId(String subClassId) {
		this.subClassId = subClassId;
	}


	public Long getStyleId() {
		return styleId;
	}


	public void setStyleId(Long styleId) {
		this.styleId = styleId;
	}


	public String getColorId() {
		return colorId;
	}


	public void setColorId(String colorId) {
		this.colorId = colorId;
	}


	public String getBrandId() {
		return brandId;
	}


	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}


	public String getVendorId() {
		return vendorId;
	}


	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}


	public String getMaterialId() {
		return materialId;
	}


	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}


	public String getSellingSeasonCode() {
		return sellingSeasonCode;
	}


	public void setSellingSeasonCode(String sellingSeasonCode) {
		this.sellingSeasonCode = sellingSeasonCode;
	}


	public List<ProductSize> getProductsize() {
		return productsize;
	}


	public void setProductsize(List<ProductSize> productsize) {
		this.productsize = productsize;
	}


	public Product(Long productid, String productname, String description, String shortDescription,
			Double averagePurchasePrice, String purchasePriceUOM, String departmentId, String classId,
			String subClassId, Long styleId, String colorId, String brandId, String vendorId, String materialId,
			String sellingSeasonCode, List<ProductSize> productsize) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.description = description;
		this.shortDescription = shortDescription;
		this.averagePurchasePrice = averagePurchasePrice;
		this.purchasePriceUOM = purchasePriceUOM;
		this.departmentId = departmentId;
		this.classId = classId;
		this.subClassId = subClassId;
		this.styleId = styleId;
		this.colorId = colorId;
		this.brandId = brandId;
		this.vendorId = vendorId;
		this.materialId = materialId;
		this.sellingSeasonCode = sellingSeasonCode;
		this.productsize = productsize;
	}


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    


}
