package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.OrdersVO;

import jakarta.transaction.Transactional;
@Repository
public interface OrdersDAO extends JpaRepository<OrdersVO, Integer>{
	
	//고객명으로 검색하는 메소드를 만들어주세요
	public List<OrdersVO> findByCustomer_Name(String name);
	
	//주문일로 검색하는 메소드 추가
	//select * from orders where orderdate=?
	public List<OrdersVO> findByOrderdate(Date orderdate);
	
	@Query(value="select nvl(max(orderid),0)+1 from orders", nativeQuery = true)
	public int getNextOrdersId();
	
	//insert,update,delete을 할때는 modifying이랑 transactional이 함께 필요하다.
	@Modifying
	@Query(value="insert into orders o(o.orderid,o.custid,o.bookid,o.saleprice,o.orderdate) "
			+ "values(:#{#vo.orderid},:#{#vo.customer.custid},:#{#vo.book.bookid},"
			+ ":#{#vo.saleprice},sysdate)", nativeQuery = true)
	@Transactional
	public void insert(@Param("vo") OrdersVO vo);
}
