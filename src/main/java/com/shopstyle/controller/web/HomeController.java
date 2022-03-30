package com.shopstyle.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

	@RequestMapping(value = "/home-page", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/home");
		return mav;
	}
	
	@RequestMapping(value = "/home-page/shop-page", method = RequestMethod.GET)
	public ModelAndView shopPage() {
		ModelAndView mav = new ModelAndView("web/shop");
		return mav;
	}
	
	@RequestMapping(value = "/home-page/cart-page", method = RequestMethod.GET)
	public ModelAndView cartPage() {
		ModelAndView mav = new ModelAndView("web/shopcart");
		return mav;
	}
	
	@RequestMapping(value = "/home-page/detail-page", method = RequestMethod.GET)
	public ModelAndView detailPage() {
		ModelAndView mav = new ModelAndView("web/detail");
		return mav;
	}
	
	@RequestMapping(value = "/home-page/contact-page", method = RequestMethod.GET)
	public ModelAndView contactPage() {
		ModelAndView mav = new ModelAndView("web/contact");
		return mav;
	}
	
	@RequestMapping(value = "/home-page/checkout-page", method = RequestMethod.GET)
	public ModelAndView checkoutPage() {
		ModelAndView mav = new ModelAndView("web/checkout");
		return mav;
	}
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
}