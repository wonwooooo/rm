package com.ww.rmwork;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;
	
	
	/*
	 * 	��ǰ ���
	 */
	@Override
	public List<Map<String, Object>> productList(Map<String, Object> map) {
		return this.productDao.productList(map);
	}
	
	
	/*
	 * 	��ǰ �߰�
	 */
	@Override
	public String product_add(Map<String, Object> map) {
		int cnt = this.productDao.product_add(map);
		
		if (cnt==1) {
			return map.get("id").toString();
		}
		return null;
	}
	
	
	/*
	 * 	��ǰ ��
	 */
	@Override
	public Map<String, Object> productDetail(Map<String, Object> map){
	    return this.productDao.productDetail(map);
	}
	
	
	

}
