package com.maggie.s4.member.memberUser;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.maggie.s4.MyTestCase;
import com.maggie.s4.member.MemberDTO;

public class MemberUserDAOTest extends MyTestCase {
	
	@Autowired
	private MemberUserDAO memberUserDAO;

	@Test
	public void getMemberLoginTest() throws Exception {
		MemberDTO dto = new MemberDTO();
		dto.setId("id1");
		dto.setPw("pw1");
		dto = memberUserDAO.getMemberLogin(dto);
		assertNotNull(dto);
	}

	@Test
	public void getMemberLoginFailTest() throws Exception {
		MemberDTO dto = new MemberDTO();
		dto.setId("id666");
		dto.setPw("pw666");
		dto = memberUserDAO.getMemberLogin(dto);
		assertNull(dto);
	}
}
