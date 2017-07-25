package com.xyz.dao;

import java.util.List;

import com.xyz.domain.XyzUser;

public interface XyzUserDao {
	public int register(XyzUser user,final String username);
	public XyzUser findUserByNameAndPassword(String userName,String userPassword);
	public XyzUser findUserByID(int userId);
	public List<XyzUser> login(String userName ,String userPassword);
	public void info(XyzUser user);
}
