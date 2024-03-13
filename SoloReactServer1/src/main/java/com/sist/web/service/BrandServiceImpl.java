package com.sist.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.BrandDAO;
import com.sist.web.dao.ClothDAO;
import com.sist.web.entity.Brand;
import com.sist.web.entity.Cloth;
import com.sist.web.entity.ClothCate;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDAO dao;
	
	@Autowired
	private ClothDAO cdao;
	@Override
	public Map BrandList(String ss, int page) {
		// TODO Auto-generated method stub
	Map map = new HashMap();
		
		int rowSize=9;
		int start= (rowSize*page)-rowSize;
		
		List<Brand> list = dao.brandList(ss, start);
		System.out.println("리스트"+list.size());
		
		
		int totalpage=dao.BrandListTotalPage(ss);
		final int BLOCK=10;
		int startpage = ((page - 1) / BLOCK) * BLOCK + 1;
		int endpage = startpage + BLOCK - 1;
		if(endpage>totalpage) {
			endpage=totalpage;
		}
		
		
		
	
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("list", list);
		map.put("startpage", startpage);
		map.put("endpage",endpage );
		
		return map;
	}

	@Override
	public Map BrandSClothList(int page, int bno) {
		// TODO Auto-generated method stub
	Map map = new HashMap();
		
		int rowSize=9;
		int start= (rowSize*page)-rowSize;
		Brand vo = dao.findByBno(bno);
		
		List<Cloth> list = cdao.brandSClothList(bno, start);
		
		
		
		int count = cdao.brandSTotalPage(bno);
		int totalpage=(int)(Math.ceil(count/9.0));
		
		final int BLOCK=10;
		int startpage = ((page - 1) / BLOCK) * BLOCK + 1;
		int endpage = startpage + BLOCK - 1;
		if(endpage>totalpage) {
			endpage=totalpage;
		}
		
		
		
		map.put("vo", vo);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("list", list);
		map.put("startpage", startpage);
		map.put("endpage",endpage );
		return map;
	}
}
