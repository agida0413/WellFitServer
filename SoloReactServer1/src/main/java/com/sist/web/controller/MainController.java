package com.sist.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.Cloth;
import com.sist.web.entity.ClothMainBrand;
import com.sist.web.service.MainService;
@CrossOrigin("http://localhost:3000")
@RestController
public class MainController {

	@Autowired
	private MainService service;
@GetMapping("/main/middle")
public List<ClothMainBrand> middle() {

	
	return service.MiddleList();
}

@GetMapping("/main/bottom")
public List<Cloth> bottom()
{
	return service.bottomList();
}
}
