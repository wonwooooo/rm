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
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	/*
	 * 	main
	 */
	@RequestMapping(value="/")
	public ModelAndView home() {
		return new ModelAndView("/main");
	}
	
	
	/*
	 * 	상품 목록
	 */
	@RequestMapping(value="productlist")
	public ModelAndView productList(@RequestParam Map<String, Object> map) {
		List<Map<String, Object>> list = this.productService.productList(map);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", list);
		mv.setViewName("/product/productlist");
		
		return mv;
	}
	
	
	/*
	 * 	상품 추가 페이지로 이동
	 */
	@RequestMapping(value="add", method = RequestMethod.GET)
	public ModelAndView add() {
		return new ModelAndView("/product/productadd");
	}
	
	
	/*
	 * 	상품 추가
	 */
	@RequestMapping(value="add", method=RequestMethod.POST)
	public ModelAndView product_add(@RequestParam Map<String, Object> map) {
	    ModelAndView mav = new ModelAndView();

	    String id = this.productService.product_add(map);
	    if (id == null) {
	        mav.setViewName("redirect:/productadd");
	    }else {
	        mav.setViewName("redirect:/detail?productid=" + id);	
	    }		

	    return mav;
	}
	
	
	
	/*
	 *  상품 상세
	 */
	@RequestMapping(value="/productdetail", method=RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		Map<String, Object> detail = this.productService.productDetail(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detail);
		
		String id = detail.get("id").toString();
		mav.addObject("id", id);
		mav.setViewName("/product/productdetail");
		
		return mav;
	}
	
	


}
