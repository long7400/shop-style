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
		result.put("GREED", "GREED");
		return result;
	}

}
