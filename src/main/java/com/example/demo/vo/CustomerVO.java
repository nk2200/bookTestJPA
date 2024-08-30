package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="customer")
public class CustomerVO {
	@Id
	private int custid;
	private String name;
	private String address;
	private String phone;
}
