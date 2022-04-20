package com.shopstyle.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.shopstyle.dto.CartDTO;

public interface ICartService {
	List<CartDTO> findAll(Pageable pageable);
	
	int getTotalItem();
}


