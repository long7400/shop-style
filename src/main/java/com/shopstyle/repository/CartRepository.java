package com.shopstyle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopstyle.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long>{

}
