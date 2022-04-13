 package com.shopstyle.controller.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopstyle.dto.CartItemDTO;

@Controller
public class CartController {
	
	@RequestMapping(value = "/home-page/cart", method = RequestMethod.GET)
	public ModelAndView cartPage( HttpSession httpSession) {
		ModelAndView mav = new ModelAndView("web/shopcart");
		Map<Long, CartItemDTO> cart = (Map<Long, CartItemDTO>) httpSession.getAttribute("cart");
		if(cart != null) {
			mav.addObject("carts", cart.values());
		}else {
			mav.addObject("carts", null);
		}
		mav.addObject("carts");

		return mav;
	}
}
