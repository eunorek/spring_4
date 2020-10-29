package com.maggie.s4.board.memo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.maggie.s4.MyTestCase;
import com.maggie.s4.util.Pager;

public class MemoDAOTest extends MyTestCase{

	@Autowired
	private MemoDAO memoDAO;
	
	//@Test
	public void insertTest() throws Exception {
		for(int i=0; i<100; i++ ) {
			MemoDTO memoDTO = new MemoDTO();
			memoDTO.setWriter("writer" + i);
			memoDTO.setContents("contents" + i);
			memoDAO.setInsert(memoDTO);
			
			if(i%10==0) {
				Thread.sleep(1000);
			}
		}
	}
	
	@Test
	public void listTest() throws Exception {
		Pager pager = new Pager();
		pager.makeRow();
		List<MemoDTO> arr = memoDAO.getList(pager);
		assertEquals(10, arr.size());
	}

}
