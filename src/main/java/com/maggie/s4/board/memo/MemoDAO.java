package com.maggie.s4.board.memo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maggie.s4.board.BoardDTO;
import com.maggie.s4.util.Pager;

@Repository
public class MemoDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.maggie.s4.board.memo.MemoDAO.";
	
	public List<MemoDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}
	
	public int setInsert(MemoDTO memoDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "setInsert", memoDTO);
	}
	
	public long getCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getCount", pager);
	}
	
	public MemoDTO getOne(MemoDTO memoDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getOne", memoDTO);
	}
	
	public int setDelete(MemoDTO memoDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "setDelete", memoDTO);
	}
}
