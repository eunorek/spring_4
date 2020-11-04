package com.maggie.s4.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cookie/**")
public class CookieController {
	
	@GetMapping("showCookie")
	public void showCookie(@CookieValue(value="name", required=false) Cookie cookie) throws Exception {
//		Cookie[] cookies = request.getCookies();
//		for(Cookie cookie: cookies) {
//			System.out.println(cookie.getName());
//			System.out.println(cookie.getValue());
//			System.out.println("==================\n");
//		}
		
		System.out.println(cookie.getName());
		System.out.println(cookie.getValue());
	}
	
	@GetMapping("makeCookie")
	public ModelAndView makeCookie(HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("bake a cookie!!");
		Cookie cookie = new Cookie("name", "maggie");
		cookie.setMaxAge(60);
		response.addCookie(cookie);
		return mv;
	}
}
