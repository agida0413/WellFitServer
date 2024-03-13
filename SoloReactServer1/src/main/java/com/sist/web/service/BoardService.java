package com.sist.web.service;

import java.util.Map;

import com.sist.web.entity.Board;

public interface BoardService {

	public Map boardList(int page);
	public String insertBoard(Board vo);
	public Board boardDetail(int no) ;
	public Board updateS(int no);
	public String boardUpdate(Board vo);
	public String boarddeleet(int no,String pwd);
}
