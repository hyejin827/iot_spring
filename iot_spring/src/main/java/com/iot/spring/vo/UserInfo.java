package com.iot.spring.vo;

public class UserInfo {

	private int uNo;
	private String uName;
	private String uId;
	private String uPwd;
	private String uEmail;
	private String admin;
	
	public int getuNo() {
		return uNo;
	}
	public void setuNo(int uNo) {
		this.uNo = uNo;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPwd() {
		return uPwd;
	}
	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "UserInfo [uNo=" + uNo + ", uName=" + uName + ", uId=" + uId + ", uPwd=" + uPwd + ", uEmail=" + uEmail
				+ ", admin=" + admin + "]";
	}
}
