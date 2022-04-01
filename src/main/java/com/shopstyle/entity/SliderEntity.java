package com.shopstyle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "slider")
public class SliderEntity extends BaseEntity{
	
	@Column(name = "image")
	private String image;

	@Column(name = "active",  columnDefinition = "TINYINT")
	private Integer code;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	
}
