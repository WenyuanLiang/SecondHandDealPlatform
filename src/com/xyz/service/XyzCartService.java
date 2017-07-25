package com.xyz.service;

import com.xyz.domain.XyzCart;
import com.xyz.domain.XyzCartId;
import com.xyz.domain.XyzGoods;
import com.xyz.domain.XyzUser;

public interface XyzCartService {
	public void add(XyzCart cart);
	public void add(XyzUser user,XyzGoods goods);
	public void add(int userId,int goodsId);
	public int check(int userId,int goodsId);
}
