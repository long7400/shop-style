package com.shopstyle.controller.web;

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

@Controller(value = "productControllerOfWeb")
public class ProductController {

	@Autowired
	private IProductService iProductService;

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

}
