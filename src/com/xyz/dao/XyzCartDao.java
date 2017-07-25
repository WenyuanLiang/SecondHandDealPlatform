package com.xyz.dao;

import com.xyz.domain.XyzCart;
import com.xyz.domain.XyzCartId;
import com.xyz.domain.XyzGoods;
import com.xyz.domain.XyzUser;

public interface XyzCartDao {
	public XyzCart findCartByUserAndGoods(XyzUser user, XyzGoods goods);
	public void update(XyzCart cart);
	public void delete(XyzCartId cartId);
	public void add(XyzCart cart);
	public int check(int useid, int goodsid);
}
