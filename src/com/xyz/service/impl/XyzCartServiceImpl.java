package com.xyz.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.xyz.dao.XyzCartDao;
import com.xyz.dao.XyzGoodsDao;
import com.xyz.dao.XyzUserDao;
import com.xyz.domain.XyzCart;
import com.xyz.domain.XyzCartId;
import com.xyz.domain.XyzGoods;
import com.xyz.domain.XyzUser;
import com.xyz.service.XyzCartService;
@Transactional
public class XyzCartServiceImpl implements XyzCartService{
	private XyzCartDao cartDao;
	private XyzUserDao userDao;
	private XyzGoodsDao goodsDao;
	

	public void setUserDao(XyzUserDao userDao) {
		this.userDao = userDao;
	}

	public void setGoodsDao(XyzGoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	public void setCartDao(XyzCartDao cartDao) {
		this.cartDao = cartDao;
	}

	@Override
	public void add(XyzCart cart) {
		cartDao.add(cart);
		
	}

	@Override
	public void add(XyzUser user, XyzGoods goods) {
		cartDao.add(cartDao.findCartByUserAndGoods(user, goods));
		
	}

	@Override
	public void add(int userId, int goodsId) {
		cartDao.add(cartDao.findCartByUserAndGoods(userDao.findUserByID(userId),goodsDao.findGoodsByID(goodsId).get(0)));
		
	}
	@Override
	public int check(int userid, int goodsid) {
		return cartDao.check(userid, goodsid);
		
	}

}
