package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrdersDAO;
import com.example.demo.vo.OrdersVO;

@Service
public class OrdersService {
	@Autowired
	OrdersDAO dao;
	
	public int getNextOrdersId() {
		return dao.getNextOrdersId();
	}
	
	public void insert(OrdersVO vo) {
		dao.insert(vo);
	}
	
	public List<OrdersVO> findAll(String keyword){
		System.out.println("keyword is null? : "+(keyword==null));
		if(keyword==null||keyword.equals("")) {
			return dao.findAll(Sort.by("orderid"));			
		}else {
			return dao.findByCustomer_Name(keyword);
		}
		
	}
	
	
	
}
