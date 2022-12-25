package com.ww.rmwork;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	

	@RequestMapping(value="/")
	public ModelAndView home() {
		return new ModelAndView("/home");
	}

	
	/*
	 * 	브라우저 주소가 create 일 때 실행되는 자바 컨트롤 메소드
	 * 	https://wikidocs.net/115240
	 * 	book/create.jsp 로 랜딩
	 */
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("book/create");
	}

	
	/*
	 * 	서비스를 이용해서 책 추가하는 메소드
	 * 	dao - insert
	 * 	service - create
	 * 	https://wikidocs.net/115247
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
	    ModelAndView mav = new ModelAndView();

	    String bookId = this.bookService.create(map);
	    if (bookId == null) {
	        mav.setViewName("redirect:/create");
	    }else {
	        mav.setViewName("redirect:/detail?bookId=" + bookId);	
	    }		

	    return mav;
	}
	
	
	/*
	 * 	https://wikidocs.net/115251
	 * 	책 상세 url 입력시 실행
	 */
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		Map<String, Object> detailMap = this.bookService.detail(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap);
		String bookId = map.get("bookId").toString();
		mav.addObject("bookId", bookId);
		mav.setViewName("/book/detail");
		
		return mav;
	}
	
	
	/*
	 * 	책 수정 화면으로 이동
	 * 	https://wikidocs.net/117265
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam Map<String, Object> map) {
	    Map<String, Object> detailMap = this.bookService.detail(map);
	    
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("data", detailMap);
	    mav.setViewName("/book/update");
	    return mav;
	}
	
	
	/*
	 * 	책 수정
	 * 	https://wikidocs.net/117267
	 * 
	 * 	bookid 는 get 파라미터로 전달
	 * 	나머지 title, category, price 는 data 객체로 form 태그를 통해 전달
	 * 
	 * 	스프링은 http 메소드를 get post 가리지 않고 requestmapping 어노테이션이 있으면 무조건 파라미터를 넣어줌
	 * 	파라미터 map 안에는 4개 데이터가 모두 들어있음
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView updatePost(@RequestParam Map<String, Object> map) {
	    ModelAndView mav = new ModelAndView();

	    boolean isUpdateSuccess = this.bookService.edit(map);		
	    if (isUpdateSuccess) {
	        String bookId = map.get("bookId").toString();
	        mav.setViewName("redirect:/detail?bookId=" + bookId);
	    }else {
	        mav = this.update(map);
	    }		

	    return mav;
	}
	
	
	/*
	 * 	책 삭제
	 * 	https://wikidocs.net/117271
	 */
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ModelAndView deletePost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		boolean isDeleteSuccess = this.bookService.remove(map);
		if (isDeleteSuccess) {
			mav.setViewName("redirect:/list");
		}
		else {
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/detail?bookId="+bookId);
		}
		
		return mav;
	}
	
	
	/*
	 * 	책 목록
	 * 	https://wikidocs.net/117273
	 */
	@RequestMapping(value="list")
	public ModelAndView list(@RequestParam Map<String, Object> map) {
		List<Map<String, Object>> list = this.bookService.list(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", list);
		mav.setViewName("/book/list");
		
		return mav;
	}
	
	
	
	
	
	
}
