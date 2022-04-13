package com.shopstyle.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopstyle.converter.CategoryConverter;
import com.shopstyle.dto.CategoryDTO;
import com.shopstyle.entity.CategoryEntity;
import com.shopstyle.repository.CategoryRepository;
import com.shopstyle.service.ICategoryService;
import com.shopstyle.util.VNCharacterUtils;

@Service
public class CategoryService implements ICategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Override
	public Map<String, String> findAll() {
		Map<String, String> result = new HashMap<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for (CategoryEntity item: entities) {
			result.put(item.getCode(), item.getName());
		}
		return result;
	}
	
	@Override
	public List<String> findAllName() {
		List<String> loadmenu = new ArrayList<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for (CategoryEntity item: entities) {
			loadmenu.add(item.getName());
		}
		return loadmenu;
	}
	
	
	@Override
	public List<CategoryDTO> findAll(Pageable pageable) {
		List<CategoryDTO> models = new ArrayList<>();
		List<CategoryEntity> entities = categoryRepository.findAll(pageable).getContent();
		for (CategoryEntity item: entities) {
			CategoryDTO productDTO = categoryConverter.toDto(item);
			models.add(productDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) categoryRepository.count();
	}

	@Override
	public CategoryDTO findById(long id) {
		CategoryEntity categoryEntity = categoryRepository.findOne(id);
		return categoryConverter.toDto(categoryEntity);
	}

	@Override
	@Transactional
	public CategoryDTO save(CategoryDTO dto) {
		CategoryEntity categoryEntity = new CategoryEntity();
		if (dto.getId() != null) {
			CategoryEntity oldCategory = categoryRepository.findOne(dto.getId());
			categoryEntity = categoryConverter.toEntity(oldCategory, dto);
			categoryEntity.setCode(VNCharacterUtils.removeAccent(categoryEntity.getName()));
			
		} else {
			categoryEntity = categoryConverter.toEntity(dto);
			categoryEntity.setCode(VNCharacterUtils.removeAccent(categoryEntity.getName()));
		}
		return categoryConverter.toDto(categoryRepository.save(categoryEntity));
	}

	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			categoryRepository.delete(id);
		}
	}

	
}
