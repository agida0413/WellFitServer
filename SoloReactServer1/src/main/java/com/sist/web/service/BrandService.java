package com.sist.web.service;

import java.util.Map;

public interface BrandService {

	public Map BrandList(String ss,int page);
	
	public Map BrandSClothList(int page,int bno);
}
