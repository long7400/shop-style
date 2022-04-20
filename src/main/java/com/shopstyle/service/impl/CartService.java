package com.shopstyle.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shopstyle.converter.CartConvertor;
import com.shopstyle.dto.CartDTO;
import com.shopstyle.entity.CartEntity;
import com.shopstyle.repository.CartRepository;
import com.shopstyle.service.ICartService;

@Service
public class CartService implements ICartService{

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartConvertor cartConvertor;
	
	@Override
	public List<CartDTO> findAll(Pageable pageable) {
		List<CartDTO> models = new ArrayList<>();
		List<CartEntity> entities = cartRepository.findAll(pageable).getContent();
		for (CartEntity item: entities) {
			CartDTO cartDTO = cartConvertor.toDto(item);
			models.add(cartDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) cartRepository.count();
	}

}
