package com.springbasic.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.springbasic.vo.Member;

@Repository // 아래의 클래스가 DAO객체임을 명시
public class MemberDAOimpl implements MemberDAO {
	
	private static String ns = "com.springbasic.mappers.MemberMapper";

	@Inject
	private SqlSession ses; // SqlSessionTemplate 객체 주입
	
	@Override
	public String getDate() {
		String q = ns + ".curDate";
		
		return ses.selectOne(q);
	}

	@Override
	public void insertMember(Member member) {
		
		ses.insert(ns + ".inpuyMemberWithoutUserImg", member);
		
	}

	@Override
	public Member selectMemberByUserId(String userId) {
		
		String q = ns + ".getMemberByUserId";
		return ses.selectOne(q, userId);
	}

}
