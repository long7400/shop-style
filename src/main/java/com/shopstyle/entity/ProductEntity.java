package com.shopstyle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity{

	@Column(name = "title")
	private String title;
	
	@Column(name = "summary", columnDefinition = "TINYTEXT", nullable = false)
	private String summary;
	
	@Column(name = "type", columnDefinition = "SMALLINT")
	private Integer type;
	
	@Column(name = "price")
	private Float price;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "shop", columnDefinition = "SMALLINT")
	private Integer shop;
	
	@Column(name = "content", columnDefinition = "TEXT")
	private String content;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getShop() {
		return shop;
	}

	public void setShop(Integer shop) {
		this.shop = shop;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


}
