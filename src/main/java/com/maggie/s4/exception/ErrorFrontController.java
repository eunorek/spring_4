package com.maggie.s4.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error/**")
public class ErrorFrontController {
	
	@GetMapping("error404")
	public ModelAndView error404() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "존재하지 않는 페이지입니다ㅠㅜ.");
		mv.setViewName("error/error_front");
		
		return mv;
	}
}
