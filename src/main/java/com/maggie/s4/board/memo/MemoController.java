package com.maggie.s4.board.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.maggie.s4.board.BoardDTO;
import com.maggie.s4.board.notice.NoticeService;
import com.maggie.s4.util.Pager;

@Controller
@RequestMapping("/memo/**")
public class MemoController {
	
	@Autowired
	private MemoService memoService;
	
	
	@GetMapping("memoList")
	public ModelAndView getList(Pager pager) throws Exception {
		System.out.println("memo list start");
		ModelAndView mv = new ModelAndView();
		List<MemoDTO> arr = memoService.getList(pager);
		mv.addObject("list", arr);
		mv.setViewName("memo/memoTest");
		return mv;
	}
	
	@PostMapping("memoWrite")
	public ModelAndView setInsert(MemoDTO memoDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = memoService.setInsert(memoDTO);
		String message = "insert fail";
		if(result>0) {
			message = "insert success";
		}
		mv.addObject("message", message);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@GetMapping("memoTest")
	public ModelAndView memoTest(MemoDTO memoDTO) throws Exception {
		System.out.println("Num: " + memoDTO.getNum());
		ModelAndView mv = new ModelAndView();
		memoDTO = memoService.getOne(memoDTO);
		
		mv.addObject("dto", memoDTO);
		mv.setViewName("memo/memoTest");
		System.out.println("writer: "+ memoDTO.getWriter());
		return mv;
	}
	
	@GetMapping("memoPage")
	public String memoPage() throws Exception{
		return "/memo/memoPage";
	}
	
	@PostMapping("memoDelete")
	public ModelAndView setDelete(MemoDTO memoDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = memoService.setDelete(memoDTO);
		String message = "delete fail";
		if(result>0) {
			message = "delete success";
		}
		mv.addObject("message", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	

}
