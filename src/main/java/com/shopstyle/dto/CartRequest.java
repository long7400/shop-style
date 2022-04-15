package com.shopstyle.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CartRequest {
	private List<CartItemDTO> cartItemDTOS;

	public List<CartItemDTO> getCartItemDTOS() {
		return cartItemDTOS;
	}

	public void setCartItemDTOS(List<CartItemDTO> cartItemDTOS) {
		this.cartItemDTOS = cartItemDTOS;
	}
	
}
