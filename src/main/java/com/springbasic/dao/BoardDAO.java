package com.springbasic.dao;

import java.util.List;

import com.springbasic.vo.Board;

public interface BoardDAO {
	// 현재 날짜와 현재 시간을 가져오는
	public String getDate();
	
	// insertBoard
	public void insertBoard(Board board);
	
	
	public Board selectBoardByNo(int no);
	
	public List<Board> selsectAllBoard();
}
