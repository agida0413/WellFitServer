package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "brand")
public class Brand {

	@Id
	private int bno;
	
	private String name;
}
