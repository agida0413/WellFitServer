package com.sist.web.controller;

import java.util.Map;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.web.service.ClothService;
import com.sist.web.service.ReplyService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@CrossOrigin("http://localhost:3000")
@RestController
public class ClothController {

	@Autowired
	private ClothService service;
	@Autowired
	private ReplyService rservice;
	@GetMapping("/cloth/list/{page}")
	public Map clothList(@PathVariable("page") int page,String ss,String category,String sex) {
		return service.clothList(page, ss, category, sex);
	}
	
	@GetMapping("/cloth/detail/{pno}")
	public Map clothDetail(@PathVariable("pno") int pno,HttpServletResponse response, HttpServletRequest request) {
	
			
		
		return service.clothDetail(pno, response,request);
	}
	
	@GetMapping("/cloth/replyList")
	public Map replyNormalList(int page,int pno) {
		System.out.println("실행");
		return rservice.replyNormalList(pno, page);
	}
	
	
}
