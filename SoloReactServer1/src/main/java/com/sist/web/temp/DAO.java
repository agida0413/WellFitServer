package com.sist.web.temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class DAO {
	private Connection conn;
	private PreparedStatement ps;
	
	private final String url="jdbc:mysql://localhost:3306/mydb?autoReconnection=true";
	
	public DAO () {
		
	}
	public void getconnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,"root","root");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void disconnection() {
		try {
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void clothInsert(clothVO vo,String category,int bno) {
		try {
			getconnection();
			String sql="INSERT INTO cloth(bno,sex,image,brand,name,originalprice,nowprice,category) "
					+ "VALUES(?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,bno );
			ps.setString(2, vo.getSex());
			ps.setString(3, vo.getImage());
			ps.setString(4, vo.getBrand());
			ps.setString(5, vo.getItem_name());
			ps.setString(6, vo.getReal_price());
			ps.setString(7, vo.getNow_price());
			ps.setString(8, category);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		
		finally {
			disconnection();
			
		}
		
		
}
	
	public void brandInsert() {
		try {
			getconnection();
			String sql1="select distinct brand from cloth where bno=0";
			List<String> list = new ArrayList<>();
			ps=conn.prepareStatement(sql1);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				String s = rs.getString(1);
				list.add(s);
			}
			disconnection();
			
			getconnection();
			for (String s : list) {
				String sql="INSERT INTO brand (name) VALUES(?)";
				ps=conn.prepareStatement(sql);
				ps.setString(1,s);
				
				ps.executeUpdate();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		
		finally {
			disconnection();
			
		}
		
		
}
}
