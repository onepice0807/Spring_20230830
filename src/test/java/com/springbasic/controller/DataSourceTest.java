package com.springbasic.controller;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DataSourceTest {
	
	@Inject
	private DataSource ds; // 스프링 컨테이너에 의해 관리되어지는 객체중에서 DataSource 타입의 객체를 주입
	
	@Test
	public void ConnectionTest() {
		System.out.println(ds.toString());
		
		 try(Connection con = this.ds.getConnection()) {
			 System.out.println(con.toString());
		 } catch (Exception e) {
			e.printStackTrace();
		}
	}
}
