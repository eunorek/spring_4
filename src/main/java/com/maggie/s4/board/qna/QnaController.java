package com.maggie.s4.board.qna;

import java.io.File;
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
import com.maggie.s4.board.file.BoardFileDTO;
import com.maggie.s4.util.Pager;

@Controller
@RequestMapping(value="/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("qnaList")
	public ModelAndView getList(Pager pager) throws Exception {
		System.out.println("QnaList!!!");
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> arr = qnaService.getList(pager);
		
		mv.addObject("list", arr);
		mv.addObject("pager", pager);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@GetMapping("qnaWrite")
	public ModelAndView setInsert() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "qna");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@PostMapping("qnaWrite")
	public ModelAndView setInsert(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setInsert(boardDTO, files, session);
		String path = "./qnaList";
		
		String message = "오류:글 등록에 실패했습니다";
		if(result > 0) {
			message = "글이 등록되었습니다";
		}
		mv.addObject("message", message);
		mv.addObject("path", path);
		mv.setViewName("common/result");
		return mv;		
	}

	@GetMapping("qnaSelect")
	public ModelAndView getOne(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();	
		boardDTO = qnaService.getOne(boardDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	@PostMapping("qnaDelete")
	public ModelAndView setDelete(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setDelete(boardDTO);
		String path = "./qnaList";
		
		String message = "글 삭제에 실패했습니다";
		if(result > 0) {
			message = "글이 삭제되었습니다";
		}
		mv.addObject("message", message);
		mv.addObject("path", path);
		mv.setViewName("common/result");
		return mv;		
	}
	
	@GetMapping("qnaReply")
	public ModelAndView setReply() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "qna");
		mv.setViewName("board/boardReply");
		return mv;
	}
	
	@PostMapping("qnaReply")
	public ModelAndView setReply(QnaDTO qnaDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		return mv;		
	}
	
	@GetMapping("fileDown")
	public ModelAndView fileDown(BoardFileDTO boardFileDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "qna");
		mv.addObject("fileDTO", boardFileDTO);
		mv.setViewName("fileDown");
		return mv;
	}
	
	@GetMapping("qnaUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getOne(boardDTO);
		mv.addObject("dto", boardDTO);
		return mv;
	}
	
	@PostMapping("summernote")
	public ModelAndView summernote(MultipartFile file, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		String fname = qnaService.summernote(file, session);
		
		String sep = File.separator;
		String name = session.getServletContext().getContextPath() + sep;
		name = name + "resources" + sep + "upload" + sep + "qna" + sep + fname;
		
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		mv.addObject("message", name);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@PostMapping("summernoteDelete")
	public ModelAndView summernoteDelete(String file, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		boolean result = qnaService.summernoteDelete(file, session);
		mv.addObject("message", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	
}
