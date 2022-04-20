package com.shopstyle.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopstyle.dto.CartDTO;
import com.shopstyle.service.ICartService;
import com.shopstyle.util.MessageUtil;

@Controller(value = "cartControllerOfAdmin")
public class CartController {
	@Autowired
	private MessageUtil messageUtil;
	
	@Autowired
	private ICartService cartService;
	
	@RequestMapping(value = "/home-admin/listCart", method = RequestMethod.GET)
	public ModelAndView listPage(@RequestParam("page") int page, 
			@RequestParam("limit") int limit, HttpServletRequest request) {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setPage(page);
		cartDTO.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/cart/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		cartDTO.setListResult(cartService.findAll(pageable));
		cartDTO.setTotalItem(cartService.getTotalItem());
		cartDTO.setTotalPage((int) Math.ceil((double) cartDTO.getTotalItem() / cartDTO.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", cartDTO);
		return mav;
	}
}
