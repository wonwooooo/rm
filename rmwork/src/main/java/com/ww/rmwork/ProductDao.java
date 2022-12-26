package com.ww.rmwork;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	/*
	 * 	상품 목록
	 */
	public List<Map<String, Object>> productList(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("rmwork.product_list", map);
	}
	
	
	/*
	 * 	상품 추가
	 */
	public int product_add(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("rmwork.product_add", map);
	}
	
	
	/*
	 * 	상품 상세
	 */
	public Map<String, Object> productDetail(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("rmwork.product_detail", map);
	}
	
	
}
