package com.shopstyle.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.shopstyle.dto.MyUser;

//Lấy role
public class SecurityUtils {
	
	public static MyUser getPrincipal() {
		//Principal: Khi login dữ liệu sẽ đc lưu vào Principal => khúc này sẽ getPrincipal để lấy thông tin ra 
		MyUser myUser = (MyUser) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
		return myUser;
	}

	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities() {
		List<String> results = new ArrayList<>();

		// Lấy code role khi put lên bên ./**/CustomUserDetailsService.java
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) (SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities());
		for (GrantedAuthority authority : authorities) {
			results.add(authority.getAuthority());
		}

		return results;
	}
}