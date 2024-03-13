package com.sist.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.ClothDAO;
import com.sist.web.entity.Cloth;
import com.sist.web.entity.ClothMainBrand;
@Service
public class MainServiceImpl implements MainService {
	@Autowired	
private ClothDAO dao;
	
	@Override
	public List<ClothMainBrand> MiddleList() {
		// TODO Auto-generated method stub
		return dao.MiddleList();
	}

	@Override
	public List<Cloth> bottomList() {
		// TODO Auto-generated method stub
		return dao.bottomList();
	}

	
}
