package com.shopstyle.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value = "/home-admin", method = RequestMethod.GET)
	public ModelAndView dashBoardPage(@RequestParam("page") int page, 
			@RequestParam("limit") int limit) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setPage(page);
		productDTO.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		productDTO.setListResult(iProductService.findAll(pageable));
		productDTO.setTotalItem(iProductService.getTotalItem());
		productDTO.setTotalPage((int) Math.ceil((double) productDTO.getTotalItem() / productDTO.getLimit()));
		mav.addObject("model", productDTO);
		return mav;
	}
	// Sử dụng chung update and new required = false sử dụng để khi không có id sẽ dục mịa cái vl = id kia
	// Nôm na if => request // else => Không lấy
	@RequestMapping(value = "/home-admin/edit", method = RequestMethod.GET)
	public ModelAndView editPage(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mav = new ModelAndView("admin/edit");
		ProductDTO productDTO = new ProductDTO();
		if(id != null) {
			productDTO = iProductService.findById(id);
		}
		mav.addObject("categories", iCategoryService.findAll());
		mav.addObject("color", iUnitService.mColor());
		mav.addObject("model", productDTO);
		return mav;
	}
	
	@RequestMapping(value = "/home-admin/list", method = RequestMethod.GET)
	public ModelAndView listPage() {
		ModelAndView mav = new ModelAndView("admin/list");
		return mav;
	}
}