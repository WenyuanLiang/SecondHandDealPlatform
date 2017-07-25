package com.xyz.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.xyz.dao.XyzOrderDao;
import com.xyz.domain.XyzOrder;
import com.xyz.service.XyzOrderService;
@Transactional
public class XyzOrderServiceImpl implements XyzOrderService{
	private XyzOrderDao orderDao;

	public void setOrderDao(XyzOrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public void add(XyzOrder order) {
		orderDao.add(order);
		
	}

}
