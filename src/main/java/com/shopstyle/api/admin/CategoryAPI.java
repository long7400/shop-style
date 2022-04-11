package com.shopstyle.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopstyle.dto.CategoryDTO;
import com.shopstyle.service.ICategoryService;


@RestController(value = "categoryAPIOfAdmin")
public class CategoryAPI {

	@Autowired
	private ICategoryService iCategoryService;
	
	@PostMapping("/api/category")
	public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
		return iCategoryService.save(categoryDTO);
	}
	
	@PutMapping("/api/category")
	public CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO) {
		return iCategoryService.save(categoryDTO);
	}
	
	@DeleteMapping("/api/category")
	public void deleteCategory(@RequestBody long[] ids) {
		iCategoryService.delete(ids);
	}
}
