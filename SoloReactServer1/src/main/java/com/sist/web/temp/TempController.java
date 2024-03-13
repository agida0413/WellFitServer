package com.sist.web.temp;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.entity.*;
import com.sist.web.*;

@Controller
public class TempController {

	@Autowired
	private TempDAO dao;
	@Autowired
	private TempBrandDAO bdao;
	
	@Autowired
	private DAO ddao;
//	@GetMapping("/")
	public void ss() throws IOException {

		int bconut=1;
		  ArrayList<clothVO>clist =new ArrayList<clothVO>();
		for(int k = 1;k<=80;k++) {
			try {
				Document doc =Jsoup.connect("https://www.musinsa.com/ranking/best?period=now&age=ALL&mainCategory=&subCategory=&leafCategory=&price=&golf=false&kids=false&newProduct=false&exclusive=false&discount=false&soldOut=false&page="+k+"&viewType=small&priceMin=&priceMax=").get();
				
			Elements rank =doc.select("ul.snap-article-list p.label-default");
			Elements sex =doc.select("div.icon_group");
			Elements brand =doc.select("div.article_info p.item_title a");
			Elements item_name = doc.select("div.article_info p.list_info a");
			Elements price =doc.select("div.article_info p.price");
			Elements image =doc.select(".list_img img");
			Elements subUrl=doc.select(".list_img .img-block");
			for(int i =0; i<rank.size();i++) {
				
				clothVO vo =new clothVO();
				vo.setRanking(Integer.parseInt(rank.get(i).text().substring(0,rank.get(i).text().indexOf("위")).replace("\ufeff","")));
				vo.setState(rank.get(i).text().substring(rank.get(i).text().indexOf("위")+1).trim());
				vo.setSex(sex.get(i).text());
				vo.setBrand(brand.get(i).text());
				vo.setItem_name(item_name.get(i).text());
				vo.setImage(image.get(i).attr("data-original"));
				vo.setSubUrl(subUrl.get(i).attr("href"));
				
				
				if (price.get(i).text().substring(0,price.get(i).text().indexOf("원")+1)==null) {
					vo.setReal_price("x");
				}
				else {
					vo.setReal_price(price.get(i).text().substring(0,price.get(i).text().indexOf("원")+1));	
				}
				
				
				vo.setNow_price(price.get(i).text().substring(price.get(i).text().indexOf(" ")+1));
				clist.add(vo);
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			for (clothVO vo : clist) {
				
				
				System.out.println("성별:"+vo.getSex());
				System.out.println("이미지:"+vo.getImage());
				System.out.println("브랜드:"+vo.getBrand());
				System.out.println("이름:"+vo.getItem_name());
				System.out.println("정가:"+vo.getReal_price());
				System.out.println("현재판매가:"+vo.getNow_price());
				

String temp="";
String category="";

	Document doc2=Jsoup.connect(vo.getSubUrl()).get();
	
		
	if(doc2.selectFirst("#fbOgDescription").attr("content")!=null) {
		temp=doc2.selectFirst("#fbOgDescription").attr("content");
		
		category=temp.substring(0,temp.indexOf(">"));
		category=category.replaceAll("제품분류 : ", "");
	}else {
		category="미분류";
	}
	
	
	

	





System.out.println("카테고리:"+category);
	           


//Brand br= bdao.findByName(vo.getBrand());
//int bno=0;
//if(br!=null) {
//	bno=br.getBno();
//}
//ddao.clothInsert(vo, category, bno);

		
		

		
		
		
	           
				System.out.println("----------------------------------------------");
			}
		
	}
		System.out.println("완료");
	
//	ddao.brandInsert();	
	}
	
}
