package com.maggie.s4.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.maggie.s4.member.MemberDTO;

@Component
public class NoticeMemberInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member");
		MemberDTO dto = (MemberDTO)obj;
		
		boolean check = false;
		if(obj != null && dto.getId().equals("admin")){
			check = true;
		}else {		
			request.setAttribute("message", "권한이 필요합니다.");
			request.setAttribute("path", "../member.memberLogin");
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/s4/");
			view.forward(request, response);
		}
		return check;
	}
}
