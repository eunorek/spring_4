package com.maggie.s4.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maggie.s4.board.BoardDAO;
import com.maggie.s4.board.BoardDTO;
import com.maggie.s4.board.file.BoardFileDTO;
import com.maggie.s4.util.Pager;

@Repository
public class QnaDAO implements BoardDAO{
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.maggie.s4.board.qna.QnaDAO.";
	
	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setInsert", boardDTO);
	}
	
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}
	
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
	}
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	
	@Override
	public BoardDTO getOne(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getOne", boardDTO);
	}
	
	@Override
	public long getCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getCount", pager);
	}

	public int setInsertFile(BoardFileDTO boardFileDTO) {
		return sqlSession.insert(NAMESPACE+"setInsertFile", boardFileDTO);
		
	}

	public int setReply(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+"setInsertFile", boardDTO);
	}
	
}
