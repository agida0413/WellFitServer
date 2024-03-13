package com.sist.web.service;

import java.util.Map;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public interface ClothService {

	public Map clothList(int page,String ss,String category,String sex);
	
	public Map clothDetail(int pno,HttpServletResponse response,HttpServletRequest request);
	
	
	
}
