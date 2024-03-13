package com.sist.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.BoardDAO;
import com.sist.web.entity.Board;
import com.sist.web.entity.BoardVO;
@Service
public class BoardServiceImpl implements BoardService {
@Autowired
private BoardDAO dao;
	@Override
	public Map boardList(int page) {
		
		Map map =new HashMap<>();
		int rowSize=10;
		int start= (rowSize*page)-rowSize;

		List<BoardVO> list= dao.boardListData(start);
		int  count = (int)dao.count();
		int totalpage=(int)(Math.ceil(count/10.0));
		final int BLOCK=10;
		int startpage=(page-1)/(BLOCK*BLOCK)+1;
		int endpage=(page-1)/(BLOCK*BLOCK)+BLOCK;
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
	public String insertBoard(Board vo) {
		// TODO Auto-generated method stub
		String result="";
		try {
			
			dao.save(vo);
			result="YES";
		} catch (Exception e) {
			// TODO: handle exception
			result="NO";
		}
		return result;
	}
	@Override
	public Board boardDetail(int no) {
		// TODO Auto-generated method stub
		Board vo=dao.findByNo(no);
		vo.setHit(vo.getHit()+1);
		dao.save(vo);
		
		return vo;
	}
	@Override
	public Board updateS(int no) {
		// TODO Auto-generated method stub
		Board vo = dao.findByNo(no);
		return vo;
	}
	@Override
	public String boardUpdate(Board vo) {
		// TODO Auto-generated method stub
		
		Board dvo = dao.findByNo(vo.getNo());
		String result= "";
		if(vo.getPwd().equals(dvo.getPwd())) {
			
			dao.save(vo);
			result="YES";
		}
		else {
			result="NO";
		}
		return result;
	}
	@Override
	public String boarddeleet(int no, String pwd) {
		// TODO Auto-generated method stub
		String result="";
		Board vo=dao.findByNo(no);

		if(vo.getPwd().equals(pwd)) {
				dao.delete(vo);
				result="yes";
			
		}
		else {
			result="no";
		}
		return result;
	}

}
