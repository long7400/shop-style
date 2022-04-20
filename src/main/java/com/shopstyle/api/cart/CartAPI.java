package com.shopstyle.api.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopstyle.dto.CartItemDTO;
import com.shopstyle.dto.ProductDTO;
import com.shopstyle.service.IProductService;
import com.shopstyle.util.CoutCart;

@RestController
public class CartAPI {
	
	@Autowired
	private IProductService iProductService;
	
	@GetMapping("api/cartProduct")
	public ResponseEntity<List<ProductDTO>> listProduct(){
		List<ProductDTO> prs = this.iProductService.findAll();
		return new ResponseEntity<>(prs, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("home-page/api/cart/{id}")
	public ResponseEntity<Integer> cart(@PathVariable(value = "id") Long id, HttpSession httpSession) {
		Map<Long,CartItemDTO> cart = (Map<Long, CartItemDTO>) httpSession.getAttribute("cart");
		if(cart == null) {
			cart = new HashMap<>();
		}
		if(cart.containsKey(id) == true) {
			CartItemDTO cartItemDTO = cart.get(id);
			cartItemDTO.setQuantity(cartItemDTO.getQuantity()+1);
		}else {
			ProductDTO p = this.iProductService.findById(id);

			CartItemDTO cartItemDTO = new CartItemDTO();
			cartItemDTO.setProduct_id(p.getId());
			cartItemDTO.setProduct_name(p.getTitle());
			cartItemDTO.setCart_id(null);
			cartItemDTO.setPrice(p.getPrice());
			cartItemDTO.setQuantity(1);
			
			cart.put(id, cartItemDTO);
		}
		
		httpSession.setAttribute("cart", cart);
		
		return new  ResponseEntity<>(CoutCart.coutCart(cart), HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@PutMapping("home-page/api/cart")
	public ResponseEntity<Integer> cartUpdate( @RequestBody CartItemDTO par, HttpSession httpSession) {
		Map<Long,CartItemDTO> cart = (Map<Long, CartItemDTO>) httpSession.getAttribute("cart");
		if(cart == null) {
			cart = new HashMap<>();
		}
		CartItemDTO c = cart.get(par.getProduct_id());
		c.setQuantity(par.getQuantity());
//		httpSession.setAttribute("cart", cart);
		
		return new  ResponseEntity<>(CoutCart.coutCart(cart), HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@DeleteMapping("home-page/api/cart/{id}")
	public ResponseEntity<Integer> cartDelete( @PathVariable(value = "id") Long id, HttpSession httpSession) {
		Map<Long,CartItemDTO> cart = (Map<Long, CartItemDTO>) httpSession.getAttribute("cart");
		if(cart != null && cart.containsKey(id)) {
			cart.remove(id);
			httpSession.setAttribute("cart", cart);	
		}
		return new  ResponseEntity<>(CoutCart.coutCart(cart), HttpStatus.OK);
	}
	
}
