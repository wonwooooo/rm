package com.ww.rmwork;

import java.util.List;
import java.util.Map;

public interface ProductService {

	List<Map<String, Object>> productList(Map<String, Object> map);

	String product_add(Map<String, Object> map);

	Map<String, Object> productDetail(Map<String, Object> map);


}
