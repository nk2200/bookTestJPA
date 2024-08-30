package com.example.demo.service;

import java.lang.reflect.Method;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;

@Service
public class BookService {
	@Autowired
	private BookDAO dao;
	
	public List<BookVO> findAll(String sname,String keyword,String searchColumn, String priceRange){
		System.out.println("===============================");
		System.out.println("Service | sname : "+sname+" / keyword :"+keyword+" / searchColumn :"+searchColumn+" /  priceRange :"+priceRange);
		
		String methodName = "find";
		
		if(keyword==null||keyword.equals("")) {
			methodName += "All";
			if(sname!=null) {
				methodName += "ByOrderBy"+sname;	
			}
		}else {
			methodName += "By"+searchColumn;
			if(sname!=null) {
				
				if(searchColumn.equals("Bookid")||searchColumn.equals("Price")) {
					switch(priceRange) {
					case "GreaterThan" : methodName += "GreaterThanOrderBy"+sname;break;
					case "LessThan" : methodName += "LessThanOrderBy"+sname;break;
					case "GreaterThanEqual" : methodName += "GreaterThanEqualOrderBy"+sname;break;
					case "LessThanEqual" : methodName += "LessThanEqualOrderBy"+sname;break;
					default : methodName += "OrderBy"+sname; break;
					}
				}else {					
					methodName += "ContainingOrderBy"+sname;
				}
			}else {
				if(!searchColumn.equals("Bookid")&&!searchColumn.equals("Price")) {
					methodName += "Containing"; 
				}else {
					switch(priceRange){
					case "GreaterThan" : methodName += "GreaterThan";break;
					case "LessThan" : methodName += "LessThan";break;
					case "GreaterThanEqual" : methodName += "GreaterThanEqual";break;
					case "LessThanEqual" : methodName += "LessThanEqual";break;
					}
				}
			}
		}
		System.out.println(methodName);
		
		List<BookVO> list = null;
		try {
			Class<?> cls = Class.forName(dao.getClass().getName());
			Method method = null; 
//			매개변수 설정
			if(keyword !=null) {
				//매개변수가 String일때랑 Int일때 나눠서 설정해줌.
				if(searchColumn.equals("Bookid")||searchColumn.equals("Price")) {
					method=cls.getDeclaredMethod(methodName, Integer.class);
					list = (List<BookVO>) method.invoke(dao, new Integer(keyword));
				}else {
					method = cls.getDeclaredMethod(methodName, String.class);
					list = (List<BookVO>) method.invoke(dao, keyword);
				}
			}else {
				method = cls.getDeclaredMethod(methodName, null);
				list = (List<BookVO>) method.invoke(dao);
			}
			
		} catch (Exception e) {
			System.out.println("class forname 예외 : "+e.getMessage());
		}
		return list;
		
	}
	
	//pk에 해당하는 레코드가 이미 있으면 update, 그렇지 않으면 insert 수행
	public void save(BookVO vo) {
		dao.save(vo);
	}
	
//	public BookVO findByBookID(int bookid) {
////		return dao.findById(bookid).get();
//		BookVO b = null;
//		Optional<BookVO> opt = dao.findById(bookid);
//		if(opt.isPresent()) {
//			b = opt.get();
//		}
//		return b;
//	}

	public BookVO findByBookID(int bookid) {
		return dao.findById(bookid).orElseThrow(()->{
			throw new NoSuchElementException("데이터가 없습니다."+bookid);
		});
	}
	
	public void delete(int bookid) {
		dao.deleteById(bookid);
	}
	
	public List<BookVO> findAllByOrderByBookname() {
		return dao.findAllByOrderByBookname();
	}
}
