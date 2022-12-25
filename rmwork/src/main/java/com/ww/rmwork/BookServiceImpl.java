package com.ww.rmwork;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDao bookDao;

	/*
	 * 	책 추가
	 */
	@Override
	public String create(Map<String, Object> map) {
	    int affectRowCount = this.bookDao.insert(map);
	    if (affectRowCount ==  1) {
	        return map.get("book_id").toString();
	    }
	    return null;	    
	}
	
	
	/*
	 * 	책 상세
	 */
	@Override
	public Map<String, Object> detail(Map<String, Object> map){
	    return this.bookDao.selectDetail(map);
	}
	
	
	/*
	 * 	책 수정
	 * 	https://wikidocs.net/117266
	 * 	1개의 행이 영향을 받았는지 확인 (return)
	 */
	@Override
	public boolean edit(Map<String, Object> map) {
		int affectRowCount = this.bookDao.update(map);
		return affectRowCount == 1;	
	}
	
	
	/*
	 * 	책 삭제
	 * 	https://wikidocs.net/117271
	 */
	@Override
	public boolean remove(Map<String, Object> map) {
	    int affectRowCount = this.bookDao.delete(map);
	    return affectRowCount == 1;	    
	}
	
	
	/*
	 * 	책 목록
	 * 	https://wikidocs.net/117272
	 */
	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) {
		return this.bookDao.selectList(map);
	}
	
	
	
	
	
	
	
}
