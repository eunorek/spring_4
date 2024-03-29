package com.maggie.s4.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.maggie.s4.board.BoardDTO;
import com.maggie.s4.board.BoardService;
import com.maggie.s4.board.file.BoardFileDTO;
import com.maggie.s4.util.FileSaver;
import com.maggie.s4.util.Pager;

@Service
public class QnaService implements BoardService {
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileSaver fileSaver;

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
	public int setInsert(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		int result = qnaDAO.setInsert(boardDTO);
		String dir = "qna";
		File dest = fileSaver.getDestinationFile(session, dir);
		
		for(int i = 0; i < files.length ; i++) {
			MultipartFile f = files[i];
			if(f.getSize() < 1 || i==0) {
				continue;
			}
			String fname = fileSaver.saveTransfer(dest, f);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setNum(boardDTO.getNum());
			boardFileDTO.setFileName(fname);
			boardFileDTO.setOrigName(f.getOriginalFilename());
			qnaDAO.setInsertFile(boardFileDTO);
		}
		
		return result;
	}
	
	public int setReply(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setReply(boardDTO);
	}
	
	public String summernote(MultipartFile file, HttpSession session) throws Exception {
		String dir = "qna";
		File dest = fileSaver.getDestinationFile(session, dir);
		
		String fname = fileSaver.saveTransfer(dest, file);
		System.out.println(fname);
		return fname;
	}
	
	public boolean summernoteDelete(String file, HttpSession session) {
		String path = session.getServletContext().getRealPath("/resources/upload/qna");
		File file2 = new File(path, file);
		boolean result = false;
		if(file2.exists()) {
			result = file2.delete();
		}
		return result;
	}
}
