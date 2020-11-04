package com.maggie.s4.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class QnaMemberInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		Object obj = session.getAttribute("member");
		
		// 로그인한 멤버만 접근 가능 
		boolean check = false;
		if(obj != null) {
			check = true;
		}
		response.sendRedirect("../member/memberLogin");
		return check;
	}
}
