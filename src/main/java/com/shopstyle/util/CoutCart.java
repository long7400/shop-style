package com.shopstyle.util;

import java.util.Map;

import com.shopstyle.dto.CartItemDTO;

public class CoutCart {
	public static int coutCart(Map<Long,CartItemDTO> cart) {
		int cout = 0;
		if(cart != null) {
			for(CartItemDTO c:cart.values())
				cout += c.getQuantity() * c.getPrice();
		}
		return cout;
	}
}
