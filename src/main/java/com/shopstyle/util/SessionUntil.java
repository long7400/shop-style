package com.shopstyle.util;

public class SessionUntil {
//	// Thông tin các mặt hàng đã mua, được lưu trữ trong Session.
//	   public static CartInfo getCartInSession(HttpServletRequest request) {
//
//	 
//	       // Thông tin giỏ hàng có thể đã lưu vào trong Session trước đó.
//	       CartInfo cartInfo = (CartInfo) request.getSession().getAttribute("myCart");
//	     
//	 
//	       // Nếu chưa tạo giỏ hàng, tạo nó.
//	       if (cartInfo == null) {
//	           cartInfo = new CartInfo();
//	         
//	 
//	           // Và lưu vào trong session.
//	           request.getSession().setAttribute("myCart", cartInfo);
//	       }
//
//	       return cartInfo;
//	   }
//
//	   public static void removeCartInSession(HttpServletRequest request) {
//	       request.getSession().removeAttribute("myCart");
//	   }
//
//	   public static void storeLastOrderedCartInSession(HttpServletRequest request, CartInfo cartInfo) {
//	       request.getSession().setAttribute("lastOrderedCart", cartInfo);
//	   }
//	 
//	   public static CartInfo getLastOrderedCartInSession(HttpServletRequest request) {
//	       return (CartInfo) request.getSession().getAttribute("lastOrderedCart");
//	   }
}
