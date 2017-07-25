package com.xyz.service.impl;

import java.util.List;

import org.springframework.test.context.transaction.TransactionConfiguration;

import com.xyz.dao.PersonDao;
import com.xyz.domain.XyzCart;
import com.xyz.domain.XyzGoods;
import com.xyz.domain.XyzOrder;
import com.xyz.domain.XyzUser;
import com.xyz.service.PersonService;
@TransactionConfiguration
public class PersonServiceImpl implements PersonService{
	private PersonDao personDao;

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
	@Override
	public XyzUser findUserById(int userid) {
		return personDao.findUserById(userid);
		
	}

	

	@Override
	public List<XyzGoods> findGoodsById(int userid) {
		// TODO Auto-generated method stub
		return personDao.findGoodsById(userid) ;
	}

	@Override
	public List<XyzGoods> findSoldById(int userid) {
		// TODO Auto-generated method stub
		return personDao.findSoldById(userid) ;
	}

	@Override
	public List<XyzGoods> findBoughtById(int userid) {
		// TODO Auto-generated method stub
		return personDao.findBoughtById(userid) ;
	}

	@Override
	public List<XyzGoods> findCartById(int userid) {
		// TODO Auto-generated method stub
		return personDao.findCartById(userid) ;
	}
	@Override
	public void deleteGoodsById(int goodsid) {
		personDao.deleteGoodsById(goodsid);
	}
	@Override
	public void deleteOrder(XyzOrder order) {
		personDao.deleteOrder(order);
		
	}
	@Override
	public void deleteCart(XyzCart cart) {
		personDao.deleteCart(cart);
		
	}
	@Override
	public void addgoods(XyzGoods goods) {
		personDao.addgoods(goods);
		
	}

}
