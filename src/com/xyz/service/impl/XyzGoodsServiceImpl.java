package com.xyz.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xyz.dao.XyzGoodsDao;
import com.xyz.domain.XyzGoods;
import com.xyz.domain.XyzUser;
import com.xyz.service.XyzGoodsService;
@Transactional
public class XyzGoodsServiceImpl implements XyzGoodsService{
	private XyzGoodsDao goodsDao;

	public void setGoodsDao(XyzGoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	@Override
	public List<XyzGoods> findGoodsById(int goodsId) {
		return goodsDao.findGoodsByID(goodsId);
	}

	@Override
	public List<XyzGoods> findGoodsByName(String goodsName) {
		return goodsDao.findGoodsByName(goodsName);
	}

	@Override
	public List<XyzGoods> findAllGoods() {
		return goodsDao.findAllGoods();
	}

	@Override
	public List<XyzGoods> findGoodsByType(String goodsType) {
		return goodsDao.findGoodsByType(goodsType);
	}
	
	@Override
	public List<XyzGoods> findSellerGoodsById(int goodsId) {
		return goodsDao.findSellerGoodsById(goodsId);
	}

	@Override
	public List<XyzGoods> findGoodsByUser(int userId) {
		return goodsDao.findGoodsByUser(userId);
	}

	@Override
	public XyzUser findSeller(int goodsId) {
		return goodsDao.findSeller(goodsId);
	}


}
