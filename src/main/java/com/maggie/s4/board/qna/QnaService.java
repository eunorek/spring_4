package com.maggie.s4.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.maggie.s4.board.BoardDTO;
import com.maggie.s4.board.BoardService;
import com.maggie.s4.util.Pager;

@Service
public class QnaService implements BoardService {
	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setDelete(boardDTO);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.setTotalCount(qnaDAO.getCount(pager));
		pager.makePage();
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getOne(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getOne(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile photo, HttpSession session) throws Exception {
		return qnaDAO.setInsert(boardDTO);
	}
	
//	public int setInsertReply(BoardDTO boardDTO) throws Exception {
//		return qnaDAO.setInsertReply(boardDTO);
//	}
}
