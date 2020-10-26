package com.maggie.s4.board.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.maggie.s4.MyTestCase;
import com.maggie.s4.board.BoardDTO;

public class NoticeDAOTest extends MyTestCase {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
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

}
