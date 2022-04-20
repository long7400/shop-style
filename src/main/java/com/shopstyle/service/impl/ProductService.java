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
	public List<ProductDTO> findAll() {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAll();
		for (ProductEntity item: entities) {
			ProductDTO productDTO = productConvert.toDto(item);
			models.add(productDTO);
		}
		return models;
	}

	@Override
	public List<ProductDTO> findByTitle(Pageable pageable, String title) {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findByTitleContaining(title, pageable).getContent();
		for (ProductEntity item: entities) {
			ProductDTO productDTO = productConvert.toDto(item);
			models.add(productDTO);
		}
		return models;
	}

	@Override
	public List<ProductDTO> findByColor(Pageable pageable, String colorName) {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAll(pageable).getContent();
		for (ProductEntity item: entities) {
			ProductDTO productDTO = productConvert.toDto(item);
			if(colorName.contains(productDTO.getColor())) {
				models.add(productDTO);
			}

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
			productEntity.setImage("https://res.cloudinary.com/shopstyle-vn/image/upload/v1650437380/product-6_ya5x6y.jpg");
			productEntity = productConvert.toEntity(oldProduct, dto);
		} else {
			productEntity = productConvert.toEntity(dto);
			productEntity.setImage("https://res.cloudinary.com/shopstyle-vn/image/upload/v1650437380/product-6_ya5x6y.jpg");
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
