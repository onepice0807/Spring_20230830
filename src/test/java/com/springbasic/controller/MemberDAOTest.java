package com.springbasic.controller;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springbasic.dao.MemberDAO;
import com.springbasic.vo.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberDAOTest {
	
	@Inject
	private MemberDAO mdao;
	
//	@Test
//	public void testGetDate() {
//	System.out.println(mdao.getDate());
//	}
	
//	@Test
//	public void testGetMember() {
//		System.out.println(mdao.selectMemberByUserId("ray1234").toString());
//	}
		
//	@Test
//	public void testInsertMember() {
//		Member m = new Member("new", "1234", "new", null, 0, 0, null, null);
//		mdao.insertMember(m);
//		
//	}
	
	@Test
	public void testSelectAllMember() {
		List<Member> lst = mdao.selsectAllMembers();
		
		for (Member m : lst) {
		System.out.println(m);
	}
		
	}
	
}
