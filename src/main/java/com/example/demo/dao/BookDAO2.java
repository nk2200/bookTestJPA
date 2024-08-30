package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.example.demo.vo.BookVO;

public class BookDAO2 implements JpaRepository<BookVO, Integer> {

	@Override
	public <S extends BookVO> List<S> saveAll(Iterable<S> entities) {
		return null;
	}

	@Override
	public List<BookVO> findAll() {
		return null;
	}

	@Override
	public List<BookVO> findAllById(Iterable<Integer> ids) {
		return null;
	}

	@Override
	public <S extends BookVO> S save(S entity) {
		return null;
	}

	@Override
	public Optional<BookVO> findById(Integer id) {
		return Optional.empty();
	}

	@Override
	public boolean existsById(Integer id) {
		return false;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
	}

	@Override
	public void delete(BookVO entity) {
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
	}

	@Override
	public void deleteAll(Iterable<? extends BookVO> entities) {
	}

	@Override
	public void deleteAll() {
	}

	@Override
	public List<BookVO> findAll(Sort sort) {
		return null;
	}

	@Override
	public Page<BookVO> findAll(Pageable pageable) {
		return null;
	}

	@Override
	public <S extends BookVO> Optional<S> findOne(Example<S> example) {
		return Optional.empty();
	}

	@Override
	public <S extends BookVO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return null;
	}

	@Override
	public <S extends BookVO> long count(Example<S> example) {
		return 0;
	}

	@Override
	public <S extends BookVO> boolean exists(Example<S> example) {
		return false;
	}

	@Override
	public <S extends BookVO, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return null;
	}

	@Override
	public void flush() {
	}

	@Override
	public <S extends BookVO> S saveAndFlush(S entity) {
		return null;
	}

	@Override
	public <S extends BookVO> List<S> saveAllAndFlush(Iterable<S> entities) {
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<BookVO> entities) {
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
	}

	@Override
	public void deleteAllInBatch() {
	}

	@Override
	public BookVO getOne(Integer id) {
		return null;
	}

	@Override
	public BookVO getById(Integer id) {
		return null;
	}

	@Override
	public BookVO getReferenceById(Integer id) {
		return null;
	}

	@Override
	public <S extends BookVO> List<S> findAll(Example<S> example) {
		return null;
	}

	@Override
	public <S extends BookVO> List<S> findAll(Example<S> example, Sort sort) {
		return null;
	}
	
}
