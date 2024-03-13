package com.sist.web.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.Cloth;
import com.sist.web.entity.ClothCate;
import com.sist.web.entity.ClothMainBrand;

public interface ClothDAO extends JpaRepository<Cloth, Integer> {

	@Query(value = "SELECT MAX(brand) as brand, MAX(image) as image, MAX(hit) as hit, MAX(bno) as bno "
			+ "FROM cloth "
			+ "GROUP BY brand "
			+ "ORDER BY hit DESC "
			+ "LIMIT 0,3; ",nativeQuery = true)
	public List<ClothMainBrand> MiddleList();
	
	@Query(value = "SELECT * FROM cloth ORDER BY hit DESC LIMIT 0,3",nativeQuery = true)
	public List<Cloth> bottomList();
	
	
	@Query(value="SELECT * FROM cloth WHERE category LIKE CONCAT('%',:category,'%') AND name LIKE CONCAT('%',:ss,'%') AND sex LIKE CONCAT('%',:sex,'%')  ORDER BY pno ASC LIMIT :start,9",nativeQuery = true)
	public List<Cloth> shopList(@Param("category") String category,@Param("ss") String ss,@Param("sex") String sex,@Param("start") int start);
	
	
	@Query(value = "SELECT COUNT(*) FROM cloth WHERE category LIKE CONCAT('%',:category,'%') AND name LIKE CONCAT('%',:ss,'%') AND sex LIKE CONCAT('%',:sex,'%') ",nativeQuery = true)
	public int shopListCount(@Param("category") String category,@Param("ss") String ss,@Param("sex") String sex);
	
	@Query(value = "SELECT CATEGORY,count(*) as count FROM cloth GROUP BY CATEGorY",nativeQuery = true)
	public List<ClothCate> cateList(); 
	
	@Query(value = "SELECT DISTINCT brand FROM cloth",nativeQuery = true)
	public List<String> brandList();
	
	public Cloth findByPno(int pno);
	
	@Query(value = "SELECT * FROM CLOTH WHERE bno=:bno ORDER BY bno LIMIT :start,9",nativeQuery = true)
	public List<Cloth> brandSClothList(@Param("bno") int bno ,@Param("start") int start);
	
	@Query(value = "SELECT COUNT(*) FROM CLOTH WHERE bno=:bno",nativeQuery = true)
	public int brandSTotalPage(int bno);
}
