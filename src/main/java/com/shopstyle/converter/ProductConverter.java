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
		result.setImage(entity.getImage());
		result.setContent(entity.getContent());
		result.setCategoryCode(entity.getCategory().getCode());
		return result;
	}
	
	public ProductEntity toEntity(ProductDTO dto) {
		ProductEntity result = new ProductEntity();
		result.setTitle(dto.getTitle());
		result.setSummary(dto.getSummary());
		result.setColor(dto.getColor());
		result.setSize(dto.getSize());
		result.setPrice(dto.getPrice());
		result.setQuantity(dto.getQuantity());
		result.setShop(dto.getShop());
		result.setImage(dto.getImage());
		result.setContent(dto.getContent());
		return result;
	}
	
	public ProductEntity toEntity(ProductEntity result,ProductDTO dto) {
		result.setTitle(dto.getTitle());
		result.setSummary(dto.getSummary());
		result.setColor(dto.getColor());
		result.setSize(dto.getSize());
		result.setPrice(dto.getPrice());
		result.setQuantity(dto.getQuantity());
		result.setShop(dto.getShop());
		result.setImage(dto.getImage());
		result.setContent(dto.getContent());
		return result;
	}
}
