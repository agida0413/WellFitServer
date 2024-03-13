package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.manager.NaverManager;

@RestController
public class OtherShoppingController {
@Autowired
private NaverManager mgr;
	
	@GetMapping("/other/shopping")
	public String otherShopping(String ss) {
		
		return mgr.newsFindData(ss); 
	}
}
