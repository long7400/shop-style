package com.shopstyle.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // Bật tính năng để sự dụng auditing
public abstract class BaseEntity {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@Column(name = "createdby")
	@CreatedBy
	private String createdBy;
	
	@Column(name = "createddate")
	@CreatedDate
	private Date createdDate;

	public Long getId() {
		return id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}


	
}
