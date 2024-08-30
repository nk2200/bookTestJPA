package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.BookService;
import com.example.demo.vo.BookVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookController {
	
	@Autowired
	public BookService bookService;
	
	@GetMapping("/book/list")
	public void list(Model model, String sname, String searchColumn, String keyword, String priceRange,HttpSession session) {
		//검색어가 ""이 오면 모두 검색시키기 위하여 세션에 있는 검색어를 삭제한다.
		//그리고 검색어에 null을 설정한다.
		if(keyword==null||keyword.equals("")) {
			session.removeAttribute("keyword");
//			session.removeAttribute("searchColumn"); 안지우고 그대로 세션유지되서 나눠도 상관없을듯
			session.removeAttribute("priceRange");
			keyword=null;
			searchColumn = null;
			priceRange=null;
		}
		System.out.println("세션sname : "+session.getAttribute("sname"));
		System.out.println("세션keyword : "+session.getAttribute("keyword"));
		//새로운 검색어가 없고, 세션에 저장된 검색어가 있다면 갖고 온다.
		if(keyword==null&&session.getAttribute("keyword")!=null) {
			keyword = (String) session.getAttribute("keyword");
			searchColumn = (String) session.getAttribute("searchColumn");
			priceRange = (String) session.getAttribute("priceRange");
		}
		
		//새로운 정렬컬럼이 없고 세션에 저장된 정렬컬럼이 있다면 갖고 온다.
		if(sname==null &&session.getAttribute("sname")!=null) {
			sname = (String) session.getAttribute("sname");
		}
		System.out.println("----------------------------------");
		System.out.println("Controller | sname : "+sname+" / keyword :"+keyword+" /searchColumn :"+searchColumn);
		
		model.addAttribute("list", bookService.findAll(sname,keyword,searchColumn,priceRange));
		
		
		//검색어가 있다면 세션에 저장한다.
		if(keyword!=null&&!keyword.equals("")) {
			session.setAttribute("keyword", keyword);
			//검색할 컬럼 선택한거 세션에 저장
			session.setAttribute("searchColumn", searchColumn);
			session.setAttribute("priceRange", priceRange);
		}
		
		//정렬을 했다면 세션에 저장한다.
//		if(sname !=null) {
//			session.setAttribute("sname", sname);
//		}
		
	}
	
	@PostMapping("/book/save")
	public String insert(BookVO vo) {
		bookService.save(vo);
		return "redirect:/book/list";
	}
	
	@GetMapping("/book/detail")
	public String detail(Model model,int bookid) {
		String view = "/book/detail";
		try {
			model.addAttribute("vo", bookService.findByBookID(bookid));			
		}catch(NoSuchElementException e) {
			view = "/error";
			model.addAttribute("msg", bookid+"번의 도서는 존재하지 않습니다.");
		}
		return view;
	}
	
	@GetMapping("/book/update")
	public void updateForm(Model model, int bookid) {
		model.addAttribute("vo", bookService.findByBookID(bookid));
	}
	
	@PostMapping("/book/update")
	public String update(BookVO vo) {
//		System.out.println(vo.toString());
		bookService.save(vo);
		return "redirect:/book/list";
	}
	
	@GetMapping("/book/delete")
	public String delete(int bookid) {
		bookService.delete(bookid);
		return "redirect:/book/list";
	}
	
	@GetMapping("/book/orderByBookname")
	public void orderByBookname(Model model){
		List<BookVO> list = bookService.findAllByOrderByBookname();
		for(BookVO vo : list) {
			System.out.println(vo.getBookname());
		}
		model.addAttribute("list", bookService.findAllByOrderByBookname());
	}
}
