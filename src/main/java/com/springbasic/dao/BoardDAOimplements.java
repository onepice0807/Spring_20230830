package com.springbasic.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import com.springbasic.vo.Board;


@Repository // 아래의 클래스가 DAO객체임을 명시
public class BoardDAOimplements implements BoardDAO {

	private static String ns = "com.springbasic.mappers.boardMapper";

	@Inject
	private SqlSession ses; // SqlSessionTemplate 객체 주입

	@Override
	public String getDate() {
		String q = ns + ".curDate";

		return ses.selectOne(q);
	}

	@Override
	public void insertBoard(Board board) {
		ses.insert(ns + ".inputBoard", board);

	}

	@Override
	public Board selectBoardByNo(int no) {
		String q = ns + ".getBoardByNo";
		return ses.selectOne(q, no);
	}

	@Override
	public List<Board> selsectAllBoard() {
		String q = ns + ".getAllBoard";
		
		return ses.selectList(q);
	}

}
