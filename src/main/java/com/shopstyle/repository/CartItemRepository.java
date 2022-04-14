package com.shopstyle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopstyle.entity.CartItemEntity;

public interface CartItemRepository extends JpaRepository<CartItemEntity, Long>{

}
