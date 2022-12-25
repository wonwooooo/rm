package com.ww.rmwork;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	/*
	 * 	책 추가
	 */
	public int insert(Map<String, Object> map) {
		  return this.sqlSessionTemplate.insert("book.insert", map);
		}
	
	
	/*
	 * 	책 상세
	 */
	public Map<String, Object> selectDetail(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("book.select_detail", map);
	}
	
	
	/*
	 * 	책 수정
	 * 	https://wikidocs.net/117266
	 */
	public int update(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("book.update", map);
	}
	
	
	/*
	 * 	책 삭제
	 * 	https://wikidocs.net/117268
	 */
	public int delete(Map<String, Object> map) {
		return this.sqlSessionTemplate.delete("book.delete", map);
	}
	
	
	/*
	 * 	책 목록
	 * 	https://wikidocs.net/117272
	 */
	public List<Map<String, Object>> selectList(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("book.select_list", map);
	}
	
	
}
