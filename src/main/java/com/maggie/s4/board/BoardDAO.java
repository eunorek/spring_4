package com.maggie.s4.board;

import java.util.List;

import com.maggie.s4.util.Pager;

public interface BoardDAO {
	// abstract 메소드의 선언부
	// insert
	public int setInsert(BoardDTO boardDTO) throws Exception;
	
	// update
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	// delete
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	// list
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	// selectOne
	public BoardDTO getOne(BoardDTO boardDTO) throws Exception;
	
	// count
	public long getCount(Pager pager) throws Exception;
}
