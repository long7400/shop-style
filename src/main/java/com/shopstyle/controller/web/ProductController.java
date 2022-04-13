package com.shopstyle.controller.web;

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

import com.shopstyle.dto.ProductDTO;
import com.shopstyle.service.IProductService;
import com.shopstyle.util.MessageUtil;

@Controller(value = "productControllerOfWeb")
public class ProductController {

	@Autowired
	private IProductService iProductService;

	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/home-page/shop-page", method = RequestMethod.GET)
	public ModelAndView shopPage(@RequestParam("page") int page, 
			@RequestParam("limit") int limit) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setPage(page);
		productDTO.setLimit(limit);
		ModelAndView mav = new ModelAndView("web/shop");
		Pageable pageable = new PageRequest(page - 1, limit);
		productDTO.setListResult(iProductService.findAll(pageable));
		productDTO.setTotalItem(iProductService.getTotalItem());
		productDTO.setTotalPage((int) Math.ceil((double) productDTO.getTotalItem() / productDTO.getLimit()));
		mav.addObject("model", productDTO);
		return mav;
	}
	
	@RequestMapping(value = "/home-page/detail-page", method = RequestMethod.GET)
	public ModelAndView detailPage(@RequestParam(value = "id", required = false) Long id,	HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/detail");
		ProductDTO productDTO = new ProductDTO();
		if(id != null) {
			productDTO = iProductService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", productDTO);
		return mav;
	}
}
