package com.xyz.service;

import java.util.List;

import com.xyz.domain.XyzGoods;
import com.xyz.domain.XyzUser;

public interface XyzGoodsService {
	public List<XyzGoods> findGoodsById(int goodsId);
	public List<XyzGoods> findGoodsByName(String goodsName);
	public List<XyzGoods> findAllGoods();
	public List<XyzGoods> findGoodsByType(String goodsType);
	public List<XyzGoods> findGoodsByUser(int userId);
	public List<XyzGoods> findSellerGoodsById(int goodsId);
	public XyzUser findSeller(int goodsId);
}
