package com.sist.web.temp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.*;
@Repository
public interface TempDAO extends JpaRepository<Cloth, Integer>{

	
	
}
