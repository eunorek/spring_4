package com.maggie.s4.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.maggie.s4.board.BoardDTO;
import com.maggie.s4.util.Pager;

@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	//@RequestMapping(value = "noticeList")
	@GetMapping("noticeList")
	public ModelAndView getList(Pager pager) throws Exception {
		System.out.println("noticeList!!");
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> arr = noticeService.getList(pager);
		mv.addObject("list", arr);
		mv.addObject("pager", pager);
		mv.addObject("board", "notice");
		System.out.println("Notice List");
		mv.setViewName("board/boardList");
		return mv;
	}
	
	// to notice Write page
	@GetMapping("noticeWrite")
	public ModelAndView setInsert() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "notice");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	// submit from notice Write page
	@PostMapping("noticeWrite")
	public ModelAndView setInsert(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setInsert(boardDTO, files, session);	
		String path = "./noticeList";
		
		String message = "오류:글 등록에 실패했습니다.";
		if(result > 0) {
			message = "글이 등록되었습니다";
		}
		mv.addObject("message", message);
		mv.addObject("path", path);
		mv.setViewName("common/result");
		return mv;		
	}
	
	// notice select page
	@GetMapping("noticeSelect")
	public ModelAndView getOne(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("num: "+boardDTO.getNum());
		boardDTO = noticeService.getOne(boardDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	@PostMapping("noticeDelete")
	public ModelAndView setDelete(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setDelete(boardDTO);
		String path = "./noticeList";
		
		String message = "글 삭제에 실패했습니다";
		if(result > 0) {
			message = "글이 삭제되었습니다";
		}
		mv.addObject("message", message);
		mv.addObject("path", path);
		mv.setViewName("common/result");
		return mv;		
	}
}
