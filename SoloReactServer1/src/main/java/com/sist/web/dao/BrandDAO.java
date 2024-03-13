package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.Brand;

public interface BrandDAO extends JpaRepository<Brand, Integer> {

	@Query(value="SELECT * FROM BRAND WHERE name LIKE CONCAT('%',:ss,'%') ORDER BY bno LIMIT :start,9",nativeQuery = true)
	public List<Brand> brandList(@Param("ss") String ss,@Param("start") int start);
	
	@Query(value = "SELECT CEIL(COUNT(*)/9.0) FROM BRAND WHERE name LIKE CONCAT('%',:ss,'%')",nativeQuery = true)
	public int BrandListTotalPage(@Param("ss") String ss);
	
	public Brand findByBno(int pno);
	
	
}
