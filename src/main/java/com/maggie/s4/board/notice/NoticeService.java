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
import com.maggie.s4.board.file.BoardFileDTO;
import com.maggie.s4.util.FileSaver;
import com.maggie.s4.util.Pager;

@Service
public class NoticeService implements BoardService{
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileSaver fileSaver;

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		int result = noticeDAO.setInsert(boardDTO);
		//boardDTO = noticeDAO.getOne(boardDTO);
		System.out.println("num: "+boardDTO.getNum());
		String dir = "notice";
		File dest = fileSaver.getDestinationFile(session, dir);
			
		for(MultipartFile f:files) {
			if(f.getSize() < 1) {
				continue;
			}
			String fname = fileSaver.saveTransfer(dest, f);
			System.out.println(fname);
			System.out.println("num: " + boardDTO.getNum());
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setNum(boardDTO.getNum());
			boardFileDTO.setFileName(fname);
			boardFileDTO.setOrigName(f.getOriginalFilename());
			noticeDAO.setInsertFile(boardFileDTO);
		}
		
		return result;
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
