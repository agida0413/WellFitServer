package com.sist.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.ReplyDAO;
import com.sist.web.entity.Cloth;
import com.sist.web.entity.PjReply;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO dao;

	@Override
	public Map replyNormalList(int pno, int page) {
		// TODO Auto-generated method stub
		
			Map map = new HashMap();
		
		int rowSize=5;
		int start= (rowSize*page)-rowSize;
		
		List<PjReply> list = dao.replyNormalList(pno, start);
		System.out.println("리스트"+list.size());
		int  count = (int)dao.replyNormalCount(pno);
		
		int totalpage=(int)(Math.ceil(count/5.0));
		final int BLOCK=10;
		int startpage = ((page - 1) / BLOCK) * BLOCK + 1;
		int endpage = startpage + BLOCK - 1;
		if(endpage>totalpage) {
			endpage=totalpage;
		}
		
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("list", list);
		map.put("startpage", startpage);
		map.put("endpage",endpage );
		return map ;
	}
	
}
