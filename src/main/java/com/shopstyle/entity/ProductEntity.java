package com.shopstyle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity {
	
	@Id // Khai báo là ID và primarykey
	@GeneratedValue(strategy = GenerationType.IDENTITY) // ID tự tăng
	private Long id;

//	private Long userId;
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
	
}
