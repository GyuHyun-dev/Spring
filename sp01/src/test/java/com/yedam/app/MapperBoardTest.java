package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/*-context.xml")
public class MapperBoardTest {

	@Autowired
	BoardMapper boardMapper;
	
	// 전체조회
	//@Test
	public void selectAll() {
		List<BoardVO> list = boardMapper.selectBoardList();
		assertTrue(!list.isEmpty());
	}
	
	// 단건조회
	@Test
	public void selectInfo() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(1001);
		BoardVO findVO = boardMapper.selectBoardInfo(boardVO);
		assertEquals(findVO.getWriter(), "박규현");
	}
	
	// 등록
	//@Test
	public void insertInfo() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("테스트");
		boardVO.setContent("테스트 입니다~!");
		boardVO.setWriter("박규현");
		boardVO.setRegdate(new Date("24/01/15"));
		boardVO.setImage("이미지");
		
		int result = boardMapper.insertBoard(boardVO);
		assertNotEquals(result, 0);
	}
}
