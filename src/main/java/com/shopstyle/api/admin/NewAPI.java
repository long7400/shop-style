package com.shopstyle.api.admin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopstyle.dto.ProductDTO;;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {
	
	@PostMapping("/api/new")
	public ProductDTO createNew(@RequestBody ProductDTO productDTO) {
		return productDTO;
	}
	
	@PutMapping("/api/new")
	public ProductDTO updateNew(@RequestBody ProductDTO productDTO) {
		return productDTO;
	}
	
	@DeleteMapping("/api/new")
	public void deleteNew(@RequestBody long[] ids) {
		System.out.println("ok");
	}
}