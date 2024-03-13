package com.sist.web.temp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.Brand;
@Repository
public interface TempBrandDAO extends JpaRepository<Brand, Integer>{

	@Query(value = "select count(*) from brand WHERE name =:name",nativeQuery = true)
	public int countNam(@Param("name") String name);
	
	public Brand  findByName(String name);
	
}
