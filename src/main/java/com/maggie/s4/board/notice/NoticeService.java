package com.maggie.s4.board.notice;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.maggie.s4.board.BoardDTO;
import com.maggie.s4.board.BoardService;
import com.maggie.s4.util.Pager;

@Service
public class NoticeService implements BoardService{
	@Autowired
	private NoticeDAO noticeDAO;

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile photo, HttpSession session) throws Exception {
		String path = session.getServletContext().getRealPath("/resources/upload/member");
		System.out.println(path);
		File dir = new File(path);
		if(!dir.exists()){
			dir.mkdirs();
		}
		
		Calendar ca = Calendar.getInstance();
		long time = ca.getTimeInMillis();
		String fname = photo.getOriginalFilename();
		fname = time + "_" + fname;
		
		byte [] arr = photo.getBytes();
		File file = new File(path, fname);
		FileCopyUtils.copy(arr, file);
		
		return noticeDAO.setInsert(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.setTotalCount(noticeDAO.getCount(pager));
		pager.makePage();
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getOne(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getOne(boardDTO);
	}
	



}
