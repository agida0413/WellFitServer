package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
/*
 * pno int AI PK 
bno int 
sex varchar(50) 
image varchar(200) 
brand varchar(100) 
name varchar(500) 
originalprice varchar(500) 
nowprice varchar(500) 
category varchar(200) 
hit int
 */
@Entity
@Data
public class Cloth {
	@Id
	private int pno;
	private String sex,image,brand,name,originalprice,nowprice,category;
	private int hit,bno;
}
