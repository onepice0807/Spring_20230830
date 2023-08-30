package com.springbasic.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {
	private String userId;
	private String userPwd;
	private String userEmail;
	private Timestamp registerDate;
	private int userImg;
	private int userPoint;
	private String memberImg;
	private String isAdmin;
	
	
	
	
}
