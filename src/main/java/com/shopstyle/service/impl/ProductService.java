package com.shopstyle.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopstyle.converter.ProductConverter;
import com.shopstyle.dto.ProductDTO;
import com.shopstyle.entity.CategoryEntity;
import com.shopstyle.entity.ProductEntity;
import com.shopstyle.repository.CategoryRepository;
import com.shopstyle.repository.ProductRepository;
import com.shopstyle.service.IProductService;

@Service
public class ProductService implements IProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConvert;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<ProductDTO> findAll(Pageable pageable) {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAll(pageable).getContent();
		for (ProductEntity item: entities) {
			ProductDTO productDTO = productConvert.toDto(item);
			models.add(productDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) productRepository.count();
	}

	@Override
	public ProductDTO findById(long id) {
		ProductEntity productEntity = productRepository.findOne(id);
		return productConvert.toDto(productEntity);
	}

	@Override
	@Transactional
	public ProductDTO save(ProductDTO dto) {
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
		ProductEntity productEntity = new ProductEntity();
		if (dto.getId() != null) {
			ProductEntity oldProduct = productRepository.findOne(dto.getId());
			oldProduct.setCategory(category);
			productEntity = productConvert.toEntity(oldProduct, dto);
		} else {
			productEntity = productConvert.toEntity(dto);
			productEntity.setCategory(category);
		}
		return productConvert.toDto(productRepository.save(productEntity));
	}

	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			productRepository.delete(id);
		}
	}
	
	
}
