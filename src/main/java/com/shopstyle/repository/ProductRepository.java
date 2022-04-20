package com.shopstyle.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shopstyle.entity.ProductEntity;
import org.springframework.data.domain.Pageable;
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
    Page<ProductEntity> findByTitleContaining(String title, Pageable pageable);
}
