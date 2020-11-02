package com.maggie.s4.board.notice;

import java.util.List;

import com.maggie.s4.board.BoardDTO;
import com.maggie.s4.board.file.BoardFileDTO;

public class NoticeDTO extends BoardDTO{
	private List<BoardFileDTO> boardFileDTOs;

	public List<BoardFileDTO> getBoardFileDTOs() {
		return boardFileDTOs;
	}

	public void setBoardFileDTOs(List<BoardFileDTO> boardFileDTOs) {
		this.boardFileDTOs = boardFileDTOs;
	}
}
