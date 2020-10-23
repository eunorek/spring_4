package com.maggie.s4.member.memberUser;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.maggie.s4.member.MemberDTO;

@Controller
@RequestMapping(value="/member/**")
public class MemberUserController {

	@Autowired
	private MemberUserService memberUserService;
	
	@GetMapping("memberLogin")
	public String getMemberLogin() {
		return "member/memberLogin";
	}
	

	@SuppressWarnings("unused")
	@PostMapping("memberLogin")
	public ModelAndView setMemberLogin(MemberDTO memberDTO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();		
		memberDTO = memberUserService.getMemberLogin(memberDTO);	
		if(memberDTO != null) {
			session.setAttribute("member", memberDTO);
			mv.setViewName("redirect:../");
		}else {
			mv.addObject("message", "로그인 실패");
			mv.addObject("path", "./memberLogin");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	@GetMapping("memberLogout")
	public ModelAndView setMemberLogout(HttpSession session) throws Exception {
		// 유지시간을 강제로 0으로 변경
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@GetMapping("memberPage")
	public ModelAndView getMemberPage() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberPage");
		return mv;
	}
	
	@GetMapping("memberUpdate")
	public ModelAndView getMemberUpdate() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberUpdate");
		return mv;
	}
	
	@PostMapping("memberUpdate")
	public ModelAndView setMemberUpdate(MemberDTO memberDTO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("Entered controller");
		MemberDTO sessionDTO = (MemberDTO) session.getAttribute("member");		
		memberDTO.setId(sessionDTO.getId());

		int result = memberUserService.setMemberUpdate(memberDTO);
		String message = "오류: 개인정보 수정에 실패했습니다";
		if(result > 0) {
			sessionDTO.setName(memberDTO.getName());
			sessionDTO.setEmail(memberDTO.getEmail());
			session.setAttribute("member", sessionDTO);
			message = "개인정보가 수정되었습니다";
		}
		mv.addObject("message", message);
		mv.addObject("path", "redirect:./memberPage");		
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("memberDelete")
	public ModelAndView setMemberDelete(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberDTO sessionDTO = (MemberDTO)session.getAttribute("member");
		int result = memberUserService.setMemberDelete(sessionDTO);
		String message = "오류: 회원 탈퇴에 실패했습니다.";
		String path = "redirect:./memberPage";
		if(result > 0) {
			path = "./memberLogout";
			message = "회원 탈퇴에 성공했습니다.";
		}
		mv.addObject("message", message);
		mv.addObject("path", path);
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("memberJoin")
	public ModelAndView setMemberJoin() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberJoin");
		return mv;
	}
	
	@PostMapping("memberJoin")
	public ModelAndView setMemberJoin(MemberDTO memberDTO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = memberUserService.setMemberInsert(memberDTO);
		String message = "오류: 회원 가입에 실패했습니다.";
		String path = "redirect:../";
		if(result > 0) {
			message = "회원 가입에 성공했습니다.";
		}
		mv.addObject("message", message);
		mv.addObject("path", path);
		mv.setViewName("common/result");		
		return mv;
	}
	
}
