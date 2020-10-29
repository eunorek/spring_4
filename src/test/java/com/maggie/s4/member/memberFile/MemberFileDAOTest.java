package com.maggie.s4.member.memberFile;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.maggie.s4.MyTestCase;

public class MemberFileDAOTest extends MyTestCase{

	@Autowired
	MemberFileDAO memberFileDAO;
	
	//@Test
	public void setInsertTestSuccess() throws Exception {
		MemberFileDTO dto = new MemberFileDTO();
		dto.setId("admin");
		dto.setFileName("1603862577285_damgom01.jpeg");
		dto.setOrigName("damgom01.jpeg");
		
		int result = memberFileDAO.setInsert(dto);
		assertNotEquals(0, result);
	}
	
	@Test(expected=RuntimeException.class)
	public void setInsertTestFail() throws Exception {
		MemberFileDTO dto = new MemberFileDTO();
		dto.setId("nada");
		dto.setFileName("1603862577285_damgom01.jpeg");
		dto.setOrigName("damgom01.jpeg");
		
		int result = memberFileDAO.setInsert(dto);
		assertEquals(0, result);
	}

}
