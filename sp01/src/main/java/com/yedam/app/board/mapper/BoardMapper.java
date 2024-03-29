package com.yedam.app.board.mapper;

import java.util.List;

import com.yedam.app.board.service.BoardVO;
import com.yedam.app.emp.service.EmpVO;

public interface BoardMapper {
	// 전체조회
	public List<BoardVO> selectBoardList();
	
	// 단건조회 : 조건 - bno
	public BoardVO selectBoardInfo(BoardVO boardVO);
	
	// 등록 : 대상 - bno(selectkey), title, content, writer, image
	public int insertBoard(BoardVO boardVO);
	
	// 수정 : 대상 - title, content, writer, image
	public int updateBoard(BoardVO boardVO);
	
	// 삭제 : 조건 - bno
	public int deleteBoard(int boardNo);
}
