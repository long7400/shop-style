package com.shopstyle.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.shopstyle.service.IUnitService;

@Service
public class UnitService implements IUnitService{

	@Override
	public Map<String, String> mColor() {
		Map<String, String> result = new HashMap<>();
		result.put("RED", "RED");
		result.put("YELLOW", "YELLOW");
		result.put("ORANGE", "ORANGE");
		result.put("GREEN", "GREEN");
		return result;
	}

	@Override
	public Map<String, String> mSize() {
		Map<String, String> result = new HashMap<>();
		result.put("XXXL", "XXXL");
		result.put("XXL", "XXL");
		result.put("XL", "XL");
		result.put("L", "L");
		result.put("M", "M");
		return result;
	}

}
