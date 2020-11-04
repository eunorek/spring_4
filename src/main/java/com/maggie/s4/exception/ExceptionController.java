package com.maggie.s4.exception;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView error1() {
		ModelAndView mv = new ModelAndView();
		System.out.println("Null pointer");
		mv.setViewName("error/error_back");
		return mv;
	}
	
	@ExceptionHandler(SQLException.class)
	public ModelAndView error2() {
		ModelAndView mv = new ModelAndView();
		System.out.println("SQL Exception");
		mv.setViewName("error/error_back");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView error3() {
		ModelAndView mv = new ModelAndView();
		System.out.println("other Exceptions...");
		mv.setViewName("error/error_back");
		return mv;
	}
}
