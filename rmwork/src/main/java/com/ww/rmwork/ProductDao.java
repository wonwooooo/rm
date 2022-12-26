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
	 * 	��ǰ ���
	 */
	public List<Map<String, Object>> productList(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("rmwork.product_list", map);
	}
	
	
	/*
	 * 	��ǰ �߰�
	 */
	public int product_add(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("rmwork.product_add", map);
	}
	
	
	/*
	 * 	��ǰ ��
	 */
	public Map<String, Object> productDetail(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("rmwork.product_detail", map);
	}
	
	
}
