package com.ww.rmwork;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	
	/*
	 * 	������ �ּҰ� create �� �� ����Ǵ� �ڹ� ��Ʈ�� �޼ҵ�
	 * 	https://wikidocs.net/115240
	 */
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("book/create");
	}

}
