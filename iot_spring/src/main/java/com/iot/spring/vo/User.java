package com.iot.spring.vo;

public class User {

	private int uiNo;
	private String uiName;
	private int uiAge;
	private String uiId;
	private String uiPwd;
	private String address;
	private int ciNo;
	private String uiRegdate;
	
	public int getUiNo() {
		return uiNo;
	}
	public void setUiNo(int uiNo) {
		this.uiNo = uiNo;
	}
	public String getUiName() {
		return uiName;
	}
	public void setUiName(String uiName) {
		this.uiName = uiName;
	}
	public int getUiAge() {
		return uiAge;
	}
	public void setUiAge(int uiAge) {
		this.uiAge = uiAge;
	}
	public String getUiId() {
		return uiId;
	}
	public void setUiId(String uiId) {
		this.uiId = uiId;
	}
	public String getUiPwd() {
		return uiPwd;
	}
	public void setUiPwd(String uiPwd) {
		this.uiPwd = uiPwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCiNo() {
		return ciNo;
	}
	public void setCiNo(int ciNo) {
		this.ciNo = ciNo;
	}
	public String getUiRegdate() {
		return uiRegdate;
	}
	public void setUiRegdate(String uiRegdate) {
		this.uiRegdate = uiRegdate;
	}
	
	@Override
	public String toString() {
		return "User [uiNo=" + uiNo + ", uiName=" + uiName + ", uiAge=" + uiAge + ", uiId=" + uiId + ", uiPwd=" + uiPwd
				+ ", address=" + address + ", ciNo=" + ciNo + ", uiRegdate=" + uiRegdate + "]";
	}
}
