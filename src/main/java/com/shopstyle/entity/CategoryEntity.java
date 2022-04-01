package com.shopstyle.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity{
	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;
	
	@OneToMany(mappedBy = "category")
	private List<ProductEntity> product = new ArrayList<>();

	public String getName() {
		return name;
	}

	public List<ProductEntity> getProduct() {
		return product;
	}

	public void setProduct(List<ProductEntity> product) {
		this.product = product;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<ProductEntity> getCate() {
		return product;
	}

	public void setCate(List<ProductEntity> product) {
		this.product = product;
	}

}
