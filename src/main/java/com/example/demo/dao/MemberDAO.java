package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.vo.MemberVO;

public interface MemberDAO extends JpaRepository<MemberVO, String> {
}
