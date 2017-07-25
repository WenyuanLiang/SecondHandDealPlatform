package com.xyz.service;

import java.util.List;

import com.xyz.domain.XyzUser;

public interface XyzUserService {
	public XyzUser findUserById(int userId);
	public List<XyzUser> login(String userName, String userPassword);
	public int register(XyzUser user,String username);
	public void infochange(XyzUser user);
}
