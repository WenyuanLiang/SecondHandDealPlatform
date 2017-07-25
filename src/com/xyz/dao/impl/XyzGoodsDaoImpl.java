package com.xyz.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xyz.dao.XyzGoodsDao;
import com.xyz.domain.XyzGoods;
import com.xyz.domain.XyzUser;

public class XyzGoodsDaoImpl extends HibernateDaoSupport implements XyzGoodsDao{

	@Override
	public List<XyzGoods> findGoodsByID(int goodsId) {
		List<XyzGoods> list = new ArrayList<XyzGoods>();
		list.add(this.getHibernateTemplate().get(XyzGoods.class, goodsId));
		return list;
	}

	@Override
	public List<XyzGoods> findGoodsByName(final String goodsName1) {
		List goodsList = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query  = session.createQuery("from XyzGoods where goodsName like '%"+goodsName1+"%' and goodsStatus = 1");
				List<XyzGoods> goodsList = query.list();
				return goodsList;
			}
		});
		return goodsList;
	}

	@Override
	public List<XyzGoods> findAllGoods() {
		return (List<XyzGoods>) this.getHibernateTemplate().find("from XyzGoods where goodsStatus = 1");
	}

	@Override
	public List<XyzGoods> findGoodsByType(String goodsType) {
		return (List<XyzGoods>) this.getHibernateTemplate().find("from XyzGoods where xyzType.typeName = ? and goodsStatus = 1",goodsType);
	}
	
	@Override
	public List<XyzGoods> findSellerGoodsById(int goodsId) {
		final XyzUser user = this.getHibernateTemplate().load(XyzGoods.class, goodsId).getXyzUser();
		List goodsList = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query  = session.createQuery("from XyzGoods where xyzUser.userId = ?");
				query.setInteger(0, user.getUserId());
				List<XyzGoods> goodsList = query.list();
				return goodsList;
			}
		});
		return goodsList;
	}

	@Override
	public List<XyzGoods> findGoodsByUser(int userId) {
		return (List<XyzGoods>)this.getHibernateTemplate().find("from XyzGoods where xyzUser.userId = ?",userId);
	}

	@Override
	public XyzUser findSeller(int goodsId) {
		return this.getHibernateTemplate().load(XyzGoods.class, goodsId).getXyzUser();
	}

}
