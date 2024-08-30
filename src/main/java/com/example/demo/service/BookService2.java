package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;

//@Service
public class BookService2 {
	@Autowired
	private BookDAO dao;
	
	public List<BookVO> findAll(String sname, String keyword){
		System.out.println("===============================");
		System.out.println("Service | sname : "+sname+" / keyword :"+keyword);
		//Bookname, 대한
		if(keyword==null||keyword.equals("")) {
			if(sname!=null) {
				switch(sname) {
				case "Bookname" : return dao.findAllByOrderByBookname();
				case "Price" : return dao.findAllByOrderByPrice();
				case "Publisher" : return dao.findAllByOrderByPublisher();
				default : return dao.findAllByOrderByBookid();
				}			
			}else {
				return dao.findAll();
			}
			/*
			 * if(sname==null) { return dao.findAll(); }else if(sname.equals("Bookname")){
			 * return dao.findAllByOrderByBookname(); }else if(sname.equals("Bookid")) {
			 * return dao.findAllByOrderByBookid(); }else if(sname.equals("Price")) { return
			 * dao.findAllByOrderByPrice(); }else{ return dao.findAllByOrderByPublisher(); }
			 */
		}else {
			if(sname!=null) {
				switch(sname) {
				case "Bookname" : return dao.findByPublisherContainingOrderByBookname(keyword);
				case "Price" : return dao.findByPublisherContainingOrderByPrice(keyword);
				case "Publisher" : return dao.findByPublisherContainingOrderByPublisher(keyword);
				default : return dao.findByPublisherContainingOrderByBookid(keyword);
				}
			}else {
				return dao.findByPublisherContaining(keyword); 
			}
			
		}
	}
	
	//pk에 해당하는 레코드가 이미 있으면 update, 그렇지 않으면 insert 수행
	public void save(BookVO vo) {
		dao.save(vo);
	}
	
	public BookVO findByBookID(int bookid) {
		return dao.findById(bookid).get();
	}
	
	public void delete(int bookid) {
		dao.deleteById(bookid);
	}
	
	public List<BookVO> findAllByOrderByBookname() {
		return dao.findAllByOrderByBookname();
	}
}
