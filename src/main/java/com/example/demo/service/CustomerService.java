package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.vo.CustomerVO;

@Service
public class CustomerService {
	@Autowired
	public CustomerDAO dao;
	
	public List<CustomerVO> findAll(){
		return dao.findAll(Sort.by("custid"));
	}
	
	public CustomerVO save(CustomerVO vo) {
		return dao.save(vo);
	}
	
	public CustomerVO findById(int custid) {
		return dao.findById(custid).get();
	}
	
	public void delete(int custid) {
		dao.deleteById(custid);
	}
	
	public int getNextCustid() {
		return dao.getNextCustId();
	}
	
}
