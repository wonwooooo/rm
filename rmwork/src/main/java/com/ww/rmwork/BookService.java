package com.ww.rmwork;

import java.util.List;
import java.util.Map;

public interface BookService {

	/*
	 * 	책 추가
	 */
	String create(Map<String, Object> map);

	
	/*
	 * 	책 상세
	 */
	Map<String, Object> detail(Map<String, Object> map);
	
	
	/*
	 * 	책 수정
	 * 	https://wikidocs.net/117267
	 */
	boolean edit(Map<String, Object> map);


	/*
	 * 	책 삭제
	 * 	https://wikidocs.net/117271
	 */
	boolean remove(Map<String, Object> map);


	/*
	 * 	책 목록
	 * 	https://wikidocs.net/117273
	 */
	List<Map<String, Object>> list(Map<String, Object> map);  

	
}
