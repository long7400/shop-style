package com.shopstyle.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopstyle.repository.CategoryRepository;
import com.shopstyle.service.ICategoryService;
import com.shopstyle.service.IHomeWebService;

@Service
public class HomeWebService implements IHomeWebService{
	
	@Autowired
	private ICategoryService iCategoryService;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Map<String, String> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
