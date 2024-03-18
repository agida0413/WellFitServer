package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.PjReply;

public interface ReplyDAO extends JpaRepository<PjReply, Integer> {

	@Query(value = "SELECT * FROM pjreply WHERE PNO=:pno and rtype=1 ORDER BY regdate DESC LIMIT :start,5",nativeQuery = true)
	public List<PjReply> replyNormalList(@Param("pno") int pno,@Param("start") int start);
	
	@Query(value="SELECT COUNT(*) FROM pjreply WHERE pno=:pno ",nativeQuery = true)
	public int replyNormalCount(@Param("pno") int pno);
	
	
	
}
