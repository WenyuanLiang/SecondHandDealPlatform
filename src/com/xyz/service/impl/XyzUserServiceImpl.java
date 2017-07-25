package com.xyz.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xyz.dao.XyzUserDao;
import com.xyz.domain.XyzUser;
import com.xyz.service.XyzUserService;

@Transactional
public class XyzUserServiceImpl implements XyzUserService{
	private XyzUserDao userDao;
	

	public void setUserDao(XyzUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public XyzUser findUserById(int userId) {
		return userDao.findUserByID(userId);
	}

	@Override
	public List<XyzUser> login(String userName, String userPassword) {
		return userDao.login(userName, userPassword);
	}

	@Override
	public int register(XyzUser user,String username) {
		return userDao.register(user,username);
		
	}

	@Override
	public void infochange(XyzUser user) {
		userDao.info(user);
		
	}

}
