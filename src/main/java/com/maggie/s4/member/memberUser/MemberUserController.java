package com.maggie.s4.member.memberUser;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.maggie.s4.member.MemberDTO;
import com.maggie.s4.member.memberFile.MemberFileDTO;

@Controller
@RequestMapping(value="/member/**")
public class MemberUserController {

	@Autowired
	private MemberUserService memberUserService;
	
	@GetMapping("memberLogin")
	public ModelAndView getMemberLogin(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberLogin");
		return mv;
	}
	

	@PostMapping("memberLogin")
	public ModelAndView setMemberLogin(MemberDTO memberDTO, String remember, HttpSession session, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("remember: " + remember);
					
		memberDTO = memberUserService.getMemberLogin(memberDTO);	
		if(memberDTO != null) {
			session.setAttribute("member", memberDTO);
			mv.setViewName("redirect:../");
		}else {
			mv.addObject("message", "로그인 실패");
			mv.addObject("path", "./memberLogin");
			mv.setViewName("common/result");
		}
		
		// remember me: if not null: set cookie
		if(remember != null) {
			Cookie cookie = new Cookie("remember", memberDTO.getId());
			cookie.setDomain("/member/memberLogin");
			// "/" : 이 사이트 내에서는 어디서든 사용 가능.
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
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
	public ModelAndView getMemberPage(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		MemberFileDTO memberFileDTO = memberUserService.getMemberImageName(memberDTO);
		String profileImg = null;
		if(memberFileDTO!=null) {
			profileImg = memberFileDTO.getFileName();
		}
		
		mv.addObject("profileImg", profileImg);
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
	public ModelAndView setMemberJoin(MemberDTO memberDTO, HttpSession session, MultipartFile photo) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = memberUserService.setMemberInsert(memberDTO, photo, session);
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
	
	@GetMapping("memberIdCheck")
	public ModelAndView getMemberIdCheck(MemberDTO memberDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		memberDTO = memberUserService.getMemberIdCheck(memberDTO);
		int result = 1; // id already exists
		if(memberDTO == null) {
			result = 0;
		}
		mv.addObject("message", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
}
