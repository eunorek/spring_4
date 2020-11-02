package com.maggie.s4.board.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.maggie.s4.MyTestCase;
import com.maggie.s4.board.BoardDTO;
import com.maggie.s4.board.file.BoardFileDTO;

public class NoticeDAOTest extends MyTestCase {

	@Autowired
	private NoticeDAO noticeDAO;
	
	//@Test
	public void insertTest() throws Exception {
		for(int i=0; i<200; i++) {
			BoardDTO dto = new BoardDTO();
			dto.setTitle("title" + i);
			dto.setWriter("Writer" + i);
			dto.setContents("Contents" + i);
			noticeDAO.setInsert(dto);
			if(i%10 == 0) {
				Thread.sleep(1000);
			}
		}		
	}
	
	@Test
	public void insertFileTest() throws Exception {
		BoardFileDTO dto = new BoardFileDTO();
		dto.setNum(1);
		dto.setOrigName("o0");
		dto.setFileName("f0");
		int result = noticeDAO.setInsertFile(dto);
		assertNotEquals(0, result);
	}
	
	@Test(expected=RuntimeException.class)
	public void insertFileTestFail() throws Exception {
		BoardFileDTO dto = new BoardFileDTO();
		dto.setNum(0);
		dto.setOrigName("o0");
		dto.setFileName("f0");
		int result = noticeDAO.setInsertFile(dto);
		assertEquals(0, result);
	}

}
