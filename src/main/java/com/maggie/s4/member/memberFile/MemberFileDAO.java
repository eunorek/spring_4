package com.maggie.s4.member.memberFile;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maggie.s4.member.MemberDTO;


@Repository
public class MemberFileDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.maggie.s4.member.memberFile.MemberFileDAO.";
	
	public int setInsert(MemberFileDTO memberFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "setInsert", memberFileDTO);
	}
	
	public MemberFileDTO getMemberImageName(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getMemberImageName", memberDTO);
	}
	
}
