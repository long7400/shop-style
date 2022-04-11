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

import com.shopstyle.util.MessageUtil;
import com.shopstyle.dto.ProductDTO;
import com.shopstyle.service.ICategoryService;
import com.shopstyle.service.IProductService;
import com.shopstyle.service.IUnitService;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {

	@Autowired
	private IProductService iProductService;
	
	@Autowired
	private ICategoryService iCategoryService;
	
	@Autowired
	private IUnitService iUnitService;
	
	@Autowired
	private MessageUtil messageUtil;
	
//	@RequestMapping(value = "/home-admin/", method = RequestMethod.GET)
//	public ModelAndView dashBoardPage() {
//		ModelAndView mav = new ModelAndView("admin/home");
//		return mav;
//	}
	
	// Sử dụng chung update and new required = false sử dụng để khi không có id sẽ dục mịa cái vl = id kia
	// Nôm na if => request // else => Không lấy
	@RequestMapping(value = "/home-admin/editProduct", method = RequestMethod.GET)
	public ModelAndView editPage(@RequestParam(value = "id", required = false) Long id,	HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/product/edit");
		ProductDTO productDTO = new ProductDTO();
		if(id != null) {
			productDTO = iProductService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("categories", iCategoryService.findAll());
		mav.addObject("color", iUnitService.mColor());
		mav.addObject("size", iUnitService.mSize());
		mav.addObject("model", productDTO);
		return mav;
	}
	
	@RequestMapping(value = "/home-admin/listProduct", method = RequestMethod.GET)
	public ModelAndView listPage(@RequestParam("page") int page, 
			@RequestParam("limit") int limit, HttpServletRequest request) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setPage(page);
		productDTO.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/product/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		productDTO.setListResult(iProductService.findAll(pageable));
		productDTO.setTotalItem(iProductService.getTotalItem());
		productDTO.setTotalPage((int) Math.ceil((double) productDTO.getTotalItem() / productDTO.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", productDTO);
		return mav;
	}
}