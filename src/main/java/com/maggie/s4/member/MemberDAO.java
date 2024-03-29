package com.maggie.s4.member;


public interface MemberDAO {
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception;
	
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception;
	
	public int setMemberDelete(MemberDTO memberDTO) throws Exception;
	
	public MemberDTO getMemberIdCheck(MemberDTO memberDTO) throws Exception;
}
