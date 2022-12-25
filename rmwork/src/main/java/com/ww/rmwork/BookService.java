package com.ww.rmwork;

import java.util.List;
import java.util.Map;

public interface BookService {

	/*
	 * 	å �߰�
	 */
	String create(Map<String, Object> map);

	
	/*
	 * 	å ��
	 */
	Map<String, Object> detail(Map<String, Object> map);
	
	
	/*
	 * 	å ����
	 * 	https://wikidocs.net/117267
	 */
	boolean edit(Map<String, Object> map);


	/*
	 * 	å ����
	 * 	https://wikidocs.net/117271
	 */
	boolean remove(Map<String, Object> map);


	/*
	 * 	å ���
	 * 	https://wikidocs.net/117273
	 */
	List<Map<String, Object>> list(Map<String, Object> map);  

	
}
