package com.ww.rmwork;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	
	/*
	 * 	브라우저 주소가 create 일 때 실행되는 자바 컨트롤 메소드
	 * 	https://wikidocs.net/115240
	 */
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("book/create");
	}

}
