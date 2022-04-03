package com.shopstyle.converter;

import org.springframework.stereotype.Component;

import com.shopstyle.dto.ProductDTO;
import com.shopstyle.entity.ProductEntity;

@Component
public class ProductConverter {

	public ProductDTO toDto(ProductEntity entity) {
		ProductDTO result = new ProductDTO();
		result.setId(entity.getId());
		result.setTitle(entity.getTitle());
		result.setSummary(entity.getSummary());
		result.setColor(entity.getColor());
		result.setSize(entity.getSize());
		result.setPrice(entity.getPrice());
		result.setQuantity(entity.getQuantity());
		result.setShop(entity.getShop());
		result.setContent(entity.getContent());
		result.setCategoryCode(entity.getCategory().getCode());
		
		return result;

	}
}
