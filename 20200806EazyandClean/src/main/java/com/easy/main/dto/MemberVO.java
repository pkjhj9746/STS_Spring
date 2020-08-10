package com.easy.main.dto;

public class MemberVO {
	private String memNum;
	private String memType;
	private String memId;
	private String memPwd ;
	private String memName ;
	private int user_birth_year ;
	private int user_birth_month ;
	private int user_birth_day ;
	private String memGen ;
	private String memEmail  ;
	private String memPhone  ;
	private String memAdd_1  ;
	private String memAdd_2  ;
	private String memAdd_3  ;
	
	public MemberVO() {
		
	}
	public MemberVO(String memNum, String memType, String memId, String memPwd, String memName, int user_birth_year,
			int user_birth_month, int user_birth_day, String memGen, String memEmail, String memPhone, String memAdd_1,
			String memAdd_2, String memAdd_3) {
		super();
		this.memNum = memNum;
		this.memType = memType;
		this.memId = memId;
		this.memPwd = memPwd;
		this.memName = memName;
		this.user_birth_year = user_birth_year;
		this.user_birth_month = user_birth_month;
		this.user_birth_day = user_birth_day;
		this.memGen = memGen;
		this.memEmail = memEmail;
		this.memPhone = memPhone;
		this.memAdd_1 = memAdd_1;
		this.memAdd_2 = memAdd_2;
		this.memAdd_3 = memAdd_3;
	}


	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPwd=" + memPwd + ", memName=" + memName + ", user_birth_year="
				+ user_birth_year + ", user_birth_month=" + user_birth_month + ", user_birth_day=" + user_birth_day
				+ ", memGen=" + memGen + ", memEmail=" + memEmail + ", memPhone=" + memPhone + ", memAdd_1=" + memAdd_1
				+ ", memAdd_2=" + memAdd_2 + ", memAdd_3=" + memAdd_3 + "]";
	}
	
	
	public String getMemNum() {
		return memNum;
	}


	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}


	public String getMemType() {
		return memType;
	}


	public void setMemType(String memType) {
		this.memType = memType;
	}


	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPwd() {
		return memPwd;
	}
	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public int getUser_birth_year() {
		return user_birth_year;
	}
	public void setUser_birth_year(int user_birth_year) {
		this.user_birth_year = user_birth_year;
	}
	public int getUser_birth_month() {
		return user_birth_month;
	}
	public void setUser_birth_month(int user_birth_month) {
		this.user_birth_month = user_birth_month;
	}
	public int getUser_birth_day() {
		return user_birth_day;
	}
	public void setUser_birth_day(int user_birth_day) {
		this.user_birth_day = user_birth_day;
	}
	public String getMemGen() {
		return memGen;
	}
	public void setMemGen(String memGen) {
		this.memGen = memGen;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemAdd_1() {
		return memAdd_1;
	}
	public void setMemAdd_1(String memAdd_1) {
		this.memAdd_1 = memAdd_1;
	}
	public String getMemAdd_2() {
		return memAdd_2;
	}
	public void setMemAdd_2(String memAdd_2) {
		this.memAdd_2 = memAdd_2;
	}
	public String getMemAdd_3() {
		return memAdd_3;
	}
	public void setMemAdd_3(String memAdd_3) {
		this.memAdd_3 = memAdd_3;
	}
}
	
	