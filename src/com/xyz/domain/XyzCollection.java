package com.xyz.domain;

public class XyzCollection {
	private int userId;
	private String userName;
	private String goodsPicture;
	public XyzCollection(int userId1,String userName2, String goodsPicture1) {
		userId = userId1;
		userName = userName2;
		goodsPicture = goodsPicture1;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGoodsPicture() {
		return goodsPicture;
	}
	public void setGoodsPicture(String goodsPicture) {
		this.goodsPicture = goodsPicture;
	}
	
	
}
