package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.CustomerService;
import com.example.demo.vo.CustomerVO;

@Controller
public class CustomerController {
	@Autowired
	public CustomerService service;
	
	@GetMapping("/customer/list")
	public void findAll(Model model){
		model.addAttribute("list", service.findAll());
	}
	
	@PostMapping("/customer/save")
	public String save(CustomerVO vo) {
		CustomerVO re = service.save(vo);
		if(re!=null) {
			return "redirect:/customer/list"; 
		}else {
			return "redirect:/error.html";
		}
	}
	
	@GetMapping("/customer/detail")
	public void findById(int custid, Model model) {
		model.addAttribute("vo", service.findById(custid));
	}
	
	@GetMapping("/customer/delete")
	public void delete(int custid) {
		service.delete(custid);
	}
	
	//새로운 고객번호를 발행해서 상태유지시켜서 간다.
	@GetMapping("/customer/insert")
	public void insert(Model model) {
		model.addAttribute("custid", service.getNextCustid());
	}
	
	@PostMapping("/customer/update")
	public String update(CustomerVO vo, int custid) {

		CustomerVO re = service.save(vo);
		if(re!=null) {
			return "redirect:/customer/list"; 
		}else {
			return "redirect:/error.html";
		}
	}
	
	@GetMapping("/customer/goToUpdate")
	public void goToUpdate(int custid, Model model) {
		CustomerVO vo = service.findById(custid);
		model.addAttribute("vo", vo);
	}
}
