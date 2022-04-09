package com.shopstyle.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shopstyle.converter.ProductConverter;
import com.shopstyle.dto.ProductDTO;
import com.shopstyle.entity.ProductEntity;
import com.shopstyle.repository.ProductRepository;
import com.shopstyle.service.IProductService;

@Service
public class ProductService implements IProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConvert;

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
		// TODO Auto-generated method stub
		ProductEntity productEntity = productRepository.findOne(id);
		return productConvert.toDto(productEntity);
	}

	@Override
	public ProductDTO save(ProductDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		
	}
	
	
}
