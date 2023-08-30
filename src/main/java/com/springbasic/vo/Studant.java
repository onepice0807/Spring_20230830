package com.springbasic.vo;

public class Studant {
	private String stuNo;
	private String stuName;
	
	public Studant() {

	}
	
	public Studant(String stuNo, String stuName) {
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
	}
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	@Override
	public String toString() {
		return "Studant [stuNo=" + stuNo + ", stuName=" + stuName + "]";
	}
}
