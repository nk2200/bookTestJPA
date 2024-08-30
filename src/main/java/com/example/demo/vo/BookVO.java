package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="book") 
//db테이블명과 class이름이 다를때 명시
public class BookVO {
	@Id
	//pk속성에 id라는 어노테이션 붙이기
	private int bookid;
	private String bookname;
	private int price;
	private String publisher;
}
