package com.shopstyle.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.shopstyle.dto.ProductDTO;

public interface IProductService {
	List<ProductDTO> findAll(Pageable pageable);
	
	List<ProductDTO> findAll();
	
	int getTotalItem();
	ProductDTO findById(long id);
	ProductDTO save(ProductDTO dto);
	void delete(long[] ids);
}
