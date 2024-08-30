package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.BookService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.OrdersService;
import com.example.demo.vo.BookVO;
import com.example.demo.vo.CustomerVO;
import com.example.demo.vo.OrdersVO;

@Controller
public class OrdersController {
	@Autowired
	public BookService bService;
	@Autowired
	public CustomerService cService;
	@Autowired
	public OrdersService oService;
	
	@GetMapping("/orders/insert")
	public void insertForm(Model model) {
		model.addAttribute("custList",cService.findAll());
		model.addAttribute("bookList",bService.findAll(null,null,null,null));
		model.addAttribute("orderid", oService.getNextOrdersId());
	}
	
	@PostMapping("/orders/save")
	public String insert(OrdersVO vo) {
		System.out.println(vo);
		CustomerVO cvo = cService.findById(vo.getCustomer().getCustid());
		BookVO bvo = bService.findByBookID(vo.getBook().getBookid());
		System.out.println("cvo: "+cvo+" /bvo :"+bvo);
		vo.setCustomer(cvo);
		vo.setBook(bvo);
		oService.insert(vo);
		return "redirect:/orders/list";
	}
	
	@GetMapping("/orders/list")
	public void findAll(Model model, String keyword) {
		model.addAttribute("list", oService.findAll(keyword));
	}
}
