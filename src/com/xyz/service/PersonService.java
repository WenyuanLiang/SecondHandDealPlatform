package com.xyz.service;

import java.util.List;

import com.xyz.domain.XyzCart;
import com.xyz.domain.XyzGoods;
import com.xyz.domain.XyzOrder;
import com.xyz.domain.XyzUser;

public interface PersonService {
	public XyzUser findUserById(int userid);
	public List<XyzGoods> findGoodsById(int userid);
	public List<XyzGoods> findSoldById(int userid);
	public List<XyzGoods> findBoughtById(int userid);
	public List<XyzGoods> findCartById(int userid);
	public void deleteGoodsById(int goodsid);
	public void deleteOrder(XyzOrder order);
	public void deleteCart(XyzCart cart);
	public void addgoods(XyzGoods goods);	
}
