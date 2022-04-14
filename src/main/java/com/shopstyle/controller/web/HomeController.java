package com.shopstyle.controller.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopstyle.dto.CartItemDTO;
import com.shopstyle.util.CoutCart;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	
	
	@ModelAttribute
	public void commonAtr(Model model, HttpSession httpSession) {
		model.addAttribute("cartCounter", CoutCart.coutCart((Map<Long, CartItemDTO>) httpSession.getAttribute("cart")));
	}
	
	@RequestMapping(value = "/home-page", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/home");
		return mav;
	}

	@RequestMapping(value = "/home-page/contact-page", method = RequestMethod.GET)
	public ModelAndView contactPage() {
		ModelAndView mav = new ModelAndView("web/contact"); // /WEB-INF/views/web/contact.jsp
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
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView resPage() {
		ModelAndView mav = new ModelAndView("dangky");
		return mav;
	}
	
	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication(); // isAuthenticated()
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth); //remove value seasion
		}
		return new ModelAndView("redirect:/home-page");
	}
	
	@RequestMapping(value = "/err404", method = RequestMethod.GET)
	public ModelAndView _404Page() {
		ModelAndView mav = new ModelAndView("err404");
		return mav;
	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}
}