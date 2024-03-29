package com.maggie.s4.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maggie.s4.board.BoardDAO;
import com.maggie.s4.board.BoardDTO;
import com.maggie.s4.board.file.BoardFileDTO;
import com.maggie.s4.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.maggie.s4.board.notice.NoticeDAO.";
	
	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setInsert", boardDTO);
	}
	
	public int setInsertFile(BoardFileDTO boardFileDTO) throws Exception {
		System.out.println("DAO!!!!");
		System.out.println(boardFileDTO.getFileNum());
		System.out.println(boardFileDTO.getNum());
		System.out.println(boardFileDTO.getFileName());
		System.out.println(boardFileDTO.getOrigName());
		return sqlSession.insert(NAMESPACE+"setInsertFile", boardFileDTO);
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


}
