package com.springbasic.dao;

import java.util.List;

import com.springbasic.vo.Member;

public interface MemberDAO {
	// 현재 날짜와 현재 시간을 가져오는
	public String getDate();
	
	// insertMember
	public void insertMember(Member member);
	
	
	public Member selectMemberByUserId(String userId);
	
	public List<Member> selsectAllMembers();
}
