package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.BookVO;

@Repository
public interface BookDAO extends JpaRepository<BookVO, Integer> {
	//각컬럼으로 정렬
	public List<BookVO> findAllByOrderByBookname();
	public List<BookVO> findAllByOrderByBookid();
	public List<BookVO> findAllByOrderByPrice();
	public List<BookVO> findAllByOrderByPublisher();
	
	//%#{publisher}%로 검색
	public List<BookVO> findByPublisherContaining(String publisher);
	//도서명으로 검색하는 메소드
	public List<BookVO>	findByBooknameContaining(String bookname);
	//가격으로 검색하는 메소드
	public List<BookVO> findByPrice(Integer price);
	//도서번호로 검색하는 매소드
	public List<BookVO> findByBookid(Integer bookid);
	
	//검색해서 출판사로 정렬하는 메소드
	public List<BookVO> findByPublisherContainingOrderByBookname(String publisher);
	public List<BookVO> findByPublisherContainingOrderByBookid(String publisher);
	public List<BookVO> findByPublisherContainingOrderByPrice(String publisher);
	public List<BookVO> findByPublisherContainingOrderByPublisher(String publisher);
	
	//도서명으로 검색하여 각 컬럼으로 정렬하는 메소드
	public List<BookVO> findByBooknameContainingOrderByBookname(String bookname);
	public List<BookVO> findByBooknameContainingOrderByBookid(String bookname);
	public List<BookVO> findByBooknameContainingOrderByPrice(String bookname);
	public List<BookVO> findByBooknameContainingOrderByPublisher(String bookname);
	
	//가격으로 검색하여 각 컬럼으로 정렬하는 메소드
	public List<BookVO> findByPriceOrderByBookname(Integer price);
	public List<BookVO> findByPriceOrderByBookid(Integer price);
	public List<BookVO> findByPriceOrderByPrice(Integer price);
	public List<BookVO> findByPriceOrderByPublisher(Integer price);	
	
	//도서번호로 검색하여 각 컬럼으로 정렬하는 메소드
	public List<BookVO> findByBookidOrderByBookname(Integer bookid);
	public List<BookVO> findByBookidOrderByBookid(Integer bookid);
	public List<BookVO> findByBookidOrderByPrice(Integer bookid);
	public List<BookVO> findByBookidOrderByPublisher(Integer bookid);
	
	//가격으로 상세 검색
	public List<BookVO> findByPriceEquals(Integer priceRange);
	public List<BookVO> findByPriceGreaterThan(Integer priceRange);
	public List<BookVO> findByPriceLessThan(Integer priceRange);
	public List<BookVO> findByPriceGreaterThanEqual(Integer priceRange);
	public List<BookVO> findByPriceLessThanEqual(Integer priceRange);
//	public List<BookVO> findByPriceNotEqual(Integer priceRange);
	
	//가격이 >인 검색하고 각 칼럼으로 정렬하는 메소드 
	public List<BookVO> findByPriceGreaterThanOrderByBookid(Integer price);
	public List<BookVO> findByPriceGreaterThanOrderByBookname(Integer price);
	public List<BookVO> findByPriceGreaterThanOrderByPrice(Integer price);
	public List<BookVO> findByPriceGreaterThanOrderByPublisher(Integer price);
	//<
	public List<BookVO> findByPriceLessThanOrderByBookid(Integer price);
	public List<BookVO> findByPriceLessThanOrderByBookname(Integer price);
	public List<BookVO> findByPriceLessThanOrderByPrice(Integer price);
	public List<BookVO> findByPriceLessThanOrderByPublisher(Integer price);

	//>=
	public List<BookVO> findByPriceGreaterThanEqualOrderByBookid(Integer price);
	public List<BookVO> findByPriceGreaterThanEqualOrderByBookname(Integer price);
	public List<BookVO> findByPriceGreaterThanEqualOrderByPrice(Integer price);
	public List<BookVO> findByPriceGreaterThanEqualOrderByPublisher(Integer price);
	
	//<=
	public List<BookVO> findByPriceLessThanEqualOrderByBookid(Integer price);
	public List<BookVO> findByPriceLessThanEqualOrderByBookname(Integer price);
	public List<BookVO> findByPriceLessThanEqualOrderByPrice(Integer price);
	public List<BookVO> findByPriceLessThanEqualOrderByPublisher(Integer price);
	
}


