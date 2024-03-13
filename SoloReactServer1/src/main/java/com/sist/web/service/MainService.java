package com.sist.web.service;

import java.util.List;

import com.sist.web.entity.Cloth;
import com.sist.web.entity.ClothMainBrand;

public interface MainService {
	public List<ClothMainBrand> MiddleList();
	public List<Cloth> bottomList();
}
