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

import com.shopstyle.dto.CategoryDTO;
import com.shopstyle.service.ICategoryService;
import com.shopstyle.util.MessageUtil;

@Controller(value = "categoryControllerOfAdmin")
public class CategoryController {
	
	@Autowired
	private ICategoryService iCategoryService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	
	@RequestMapping(value = "/home-admin/listCategory", method = RequestMethod.GET)
	public ModelAndView lisCategory(@RequestParam("page") int page, 
			@RequestParam("limit") int limit, HttpServletRequest request) {
		
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setPage(page);
		categoryDTO.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/category/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		categoryDTO.setListResult(iCategoryService.findAll(pageable));
		categoryDTO.setTotalItem(iCategoryService.getTotalItem());
		categoryDTO.setTotalPage((int) Math.ceil((double) categoryDTO.getTotalItem() / categoryDTO.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", categoryDTO);
		return mav;
	}
	
	
	@RequestMapping(value = "/home-admin/editCategory", method = RequestMethod.GET)
	public ModelAndView editPage(@RequestParam(value = "id", required = false) Long id,	HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/category/edit");
		CategoryDTO categoryDTO = new CategoryDTO();
		if(id != null) {
			categoryDTO = iCategoryService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", categoryDTO);
		return mav;
	}
}
