 package com.shopstyle.controller.web;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopstyle.dto.CartItemDTO;
import com.shopstyle.dto.CartRequest;
import com.shopstyle.entity.CartItemEntity;
import com.shopstyle.entity.ProductEntity;
import com.shopstyle.repository.CartItemRepository;
import com.shopstyle.repository.CartRepository;
import com.shopstyle.repository.ProductRepository;

@Controller
public class CartController {
	
	@Autowired
	private CartItemRepository cartItemRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value = "/home-page/cart", method = RequestMethod.GET)
	public ModelAndView cartPage( HttpSession httpSession) {
		ModelAndView mav = new ModelAndView("web/shopcart");
		Map<Long, CartItemDTO> cart = (Map<Long, CartItemDTO>) httpSession.getAttribute("cart");
		CartRequest cartRequest = new CartRequest();
		if(cart != null) {
			cartRequest.setCartItemDTOS(new ArrayList<CartItemDTO>(cart.values()));
		}else {
		}
		mav.addObject("carts", cartRequest);
		return mav;
	}
	
	@RequestMapping(value = "/updateCart", method = RequestMethod.POST)
	public ModelAndView updateCart(HttpSession httpSession, @ModelAttribute("carts") CartRequest cartRequest) {
//		CartEntity c = cartRepository.save(new CartEntity());
		ModelAndView mav = new ModelAndView("web/shopcart");
		Map<Long, CartItemDTO> cart = (Map<Long, CartItemDTO>) httpSession.getAttribute("cart");
		for (CartItemDTO cartItemDTO: cartRequest.getCartItemDTOS()) {
			CartItemEntity cartItemEntity = new CartItemEntity();
			ProductEntity productEntity = productRepository.getOne(cartItemDTO.getProduct_id());
			cartItemEntity.setProduct(productEntity);
			cartItemEntity.setQuantity(cartItemDTO.getQuantity());
			cartItemEntity.setPrice(cartItemDTO.getQuantity() * productEntity.getPrice());
			cartItemRepository.save(cartItemEntity);

			CartItemDTO cartItemDTO1 = cart.get(cartItemDTO.getProduct_id());
			cartItemDTO1.setQuantity(cartItemDTO.getQuantity());

		}


		CartRequest cartRequest2 = new CartRequest();
		if(cart != null) {
//			List<V> al = ;
			cartRequest2.setCartItemDTOS(new ArrayList<CartItemDTO>(cart.values()));
		}else {
//			mav.addObject("carts", null);
		}
		mav.addObject("carts", cartRequest2);

		return mav;
	}
}
