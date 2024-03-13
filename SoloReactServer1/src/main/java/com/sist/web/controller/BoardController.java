package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.BoardDAO;
import com.sist.web.entity.Board;
import com.sist.web.entity.BoardVO;
import com.sist.web.service.BoardService;

import jakarta.transaction.Transactional;
@CrossOrigin("http://localhost:3000")
@RestController
public class BoardController {
@Autowired
private BoardService service;

@GetMapping("/board/list_react")
public Map boardList(int page) {


return service.boardList(page);
	
}


@PostMapping("/board/insert_react")
public String insertBoard(Board vo) {

	
	return service.insertBoard(vo);
	
}
@Transactional
@GetMapping("/board/detail_react")
public Board boardDetail(int no) {
	
	return service.boardDetail(no);
}

@GetMapping("/board/update_react")
public Board updateS(int no) {
	
	
	return service.updateS(no);
}

@PostMapping("/board/update_ok_react")
public String boardUpdate(Board vo) {



return service.boardUpdate(vo);
}

@PostMapping("/board/delete_react")
public String boarddeleet(int no,String pwd) {

	return service.boarddeleet(no, pwd);
}


}
