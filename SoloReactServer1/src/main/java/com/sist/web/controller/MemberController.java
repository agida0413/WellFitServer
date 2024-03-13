package com.sist.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.sist.web.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
@CrossOrigin("http://localhost:3000")
@RestController
public class MemberController {

@Autowired
private MemberService service;

@PostMapping("/member/login")
public Map memberLogin(String id,String pwd,HttpSession session,HttpServletRequest request) {
	Map map =new HashMap<>();
	String result=service.memberLogin(id, pwd,session);
	map.put("result", result);
	map.put("sid", session.getAttribute("id"));
	map.put("sname", session.getAttribute("name"));
	return map;
	
}


@GetMapping("/member/logout")
public String memberLogout(HttpSession session) {
	String result="";
	try {
		result="YES";
		session.invalidate();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		result="NO";
	}
	return result;
}
}
