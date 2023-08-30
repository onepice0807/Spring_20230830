package com.springbasic.controller;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springbasic.dao.BoardDAO;
import com.springbasic.vo.Board;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOTest {
	
	@Inject
	private BoardDAO mdao;
	
//	@Test
//	public void testGetDate() {
//	System.out.println(mdao.getDate());
//	}
//	
//	@Test
//	public void testGetBoard() {
//		System.out.println(mdao.selectBoardByNo(27));
//
//	}
		
	@Test
	public void testInsertBoard() {
		Board b = new Board(53, "ray1234", "스프링으로 연습합니다", null, "스프링으로 연습합니다", 0, 0, 0, 0, 0, "N");
		mdao.insertBoard(b);
		
	}
	
//	@Test
//	public void testSelectAllBoard() {
//		List<Board> lst = mdao.selsectAllBoard();
//		for (Board b : lst) {
//		System.out.println(b);
//	}
//		
//	}
	
}
