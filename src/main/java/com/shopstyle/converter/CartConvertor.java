package com.shopstyle.converter;

import org.springframework.stereotype.Component;

import com.shopstyle.dto.CartDTO;
import com.shopstyle.entity.CartEntity;

@Component
public class CartConvertor {
	
	public CartDTO toDto(CartEntity entity) {
		CartDTO result = new CartDTO();
		result.setId(entity.getId());
		result.setAddress(entity.getAddress());
		result.setPhone(entity.getPhone());
		result.setStatus(entity.getStatus());
		result.setTotal(entity.getTotal());
		result.setCreatedBy(entity.getCreatedBy());
		result.setCreatedDate(entity.getCreatedDate());
		return result;
	}
}
