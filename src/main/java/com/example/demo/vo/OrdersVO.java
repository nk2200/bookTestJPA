package com.example.demo.vo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name="orders")
public class OrdersVO {
	@Id
	private int orderid;
	
	//연관관계에 있는 Entity를 멤버로 둔다.
	@ManyToOne //1(부모):다(자식)의 관계
	@JoinColumn(name="custid", insertable=true, updatable=true)
	private CustomerVO customer;
//	private int custid;
	
	@ManyToOne
	@JoinColumn(name="bookid", insertable=true, updatable=true)
	private BookVO book;
//	private int bookid;
	
	private int saleprice;
	private Date orderdate;
}
