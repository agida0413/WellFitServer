package com.sist.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.BoardService;
import com.sist.web.service.BrandService;
@CrossOrigin("http://localhost:3000")
@RestController
public class BrandController {
@Autowired
private BrandService service;
	
	@GetMapping("/brand/list/{page}")
	public Map brandList(@RequestParam("ss") String ss, @PathVariable("page") int page) {
		
		return service.BrandList(ss, page); 
	}
	
	@GetMapping("/brand/detail/{bno}/{page}")
	public Map brandDetail(@PathVariable("page") int page,@PathVariable("bno") int bno) {
		return service.BrandSClothList(page, bno);
	}
}
