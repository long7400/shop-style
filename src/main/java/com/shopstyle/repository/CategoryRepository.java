package com.shopstyle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopstyle.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	CategoryEntity findOneByCode(String code);
}
