package com.sist.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.web.dao.ClothDAO;
import com.sist.web.entity.BoardVO;
import com.sist.web.entity.Cloth;
import com.sist.web.entity.ClothCate;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;

@Service
public class ClothServiceImpl implements ClothService{
@Autowired
private ClothDAO dao;
	@Override
	public Map clothList(int page, String ss, String category,String sex) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		
		int rowSize=9;
		int start= (rowSize*page)-rowSize;
		
		List<Cloth>list = dao.shopList(category, ss, sex, start);
		System.out.println("리스트"+list.size());
		int  count = (int)dao.shopListCount(category, ss, sex);
		
		int totalpage=(int)(Math.ceil(count/9.0));
		final int BLOCK=10;
		int startpage = ((page - 1) / BLOCK) * BLOCK + 1;
		int endpage = startpage + BLOCK - 1;
		if(endpage>totalpage) {
			endpage=totalpage;
		}
		List<ClothCate> cateList =dao.cateList();
		String ct="전체";
		int sum=0;
		for (ClothCate clothCate : cateList) {
				sum+=clothCate.getCount();
		
		}
		map.put("total", sum);
		
		List<String> brandList=dao.brandList();
		map.put("cateList", cateList);
		map.put("brandList", brandList);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("list", list);
		map.put("startpage", startpage);
		map.put("endpage",endpage );
		
		return map;
	}
	public Map clothDetail(int pno, HttpServletResponse response, HttpServletRequest request) {
	    try {
	    	Cookie cookie = new Cookie("pno_" + pno, String.valueOf(pno));
	    	cookie.setPath("/");
	    	cookie.setMaxAge(60 * 60 * 24);
	    	cookie.setSecure(true); // Secure 설정 추가 (HTTPS 연결에서만 쿠키 전송)
	    	response.addCookie(cookie);

	    	
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    Cookie[] cookies = request.getCookies();
	    List<Cloth> list = new ArrayList<>();
	    if (cookies != null) {
	        int count = 0;
	        for (int i = cookies.length - 1; i >= 0; i--) {
	            if (cookies[i].getName().startsWith("pno_")) {
	                String cvalue = cookies[i].getValue();
	                int cpno = Integer.parseInt(cvalue);
	                Cloth vo = dao.findByPno(cpno);
	                list.add(vo);
	                count++;
	                if (count == 4) {
	                    break;
	                }
	            }
	        }
	    }

	    Map<String, Object> map = new HashMap<>();
	    Cloth vo = dao.findByPno(pno);
	    vo.setHit(vo.getHit() + 1);
	    map.put("cList", list);
	    map.put("vo", vo);

	    return map;
	}

}
