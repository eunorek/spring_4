package com.maggie.s4.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.maggie.s4.board.BoardDTO;
import com.maggie.s4.board.qna.QnaDAO;
import com.maggie.s4.member.MemberDTO;

@Component
public class QnaUpdateInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("after entering Controller");
		HttpSession session = request.getSession();
		MemberDTO memberDTO = (MemberDTO)(session.getAttribute("member"));
		String id = memberDTO.getId();
		
		// get writer
		Map<String, Object> model = modelAndView.getModel();
		BoardDTO boardDTO = (BoardDTO)model.get("dto");
		String writer = boardDTO.getWriter();
		
		if(!id.equals(writer)) {
			modelAndView.addObject("message", "작성자만 수정 가능합니다.");
			modelAndView.addObject("path", "./qnaList");
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
}
