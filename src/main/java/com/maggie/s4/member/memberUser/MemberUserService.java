package com.maggie.s4.member.memberUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maggie.s4.member.MemberDTO;
import com.maggie.s4.member.MemberService;

@Service
public class MemberUserService implements MemberService{

	@Autowired
	private MemberUserDAO memberUserDAO;
	
	@Override
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.getMemberLogin(memberDTO);
	}

	@Override
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.setMemberUpdate(memberDTO);
	}
		
	@Override
	public int setMemberDelete(MemberDTO memberDTO) throws Exception {
		return memberUserDAO.setMemberDelete(memberDTO);
	}
	
	public MemberDTO getMemberOne(MemberDTO memberDTO) throws Exception {
		return memberUserDAO.getMemberOne(memberDTO);
	}	
	
	public int setMemberInsert(MemberDTO memberDTO) throws Exception {
		return memberUserDAO.setMemberInsert(memberDTO);
	}

	@Override
	public MemberDTO getMemberIdCheck(MemberDTO memberDTO) throws Exception {
		return memberUserDAO.getMemberIdCheck(memberDTO);
	}
}
