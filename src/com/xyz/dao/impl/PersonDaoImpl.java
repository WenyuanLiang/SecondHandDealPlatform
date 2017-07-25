package com.xyz.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xyz.dao.PersonDao;
import com.xyz.domain.XyzCart;
import com.xyz.domain.XyzGoods;
import com.xyz.domain.XyzOrder;
import com.xyz.domain.XyzUser;

public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao {

	@Override
	public XyzUser findUserById(int userid) {
		return this.getHibernateTemplate().get(XyzUser.class, userid);
	}

	@Override
	public List<XyzGoods> findGoodsById(int userid) {
		final XyzUser user = this.getHibernateTemplate().get(XyzUser.class, userid);
		/*return (List<XyzGoods>)this.getHibernateTemplate().find("from XyzGoods where xyzUser= ?  and goodsStatus = 0");*/
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query  = session.createQuery("from XyzGoods where xyzUser= ?  and goodsStatus = 1");
				query.setEntity(0, user);
				List<XyzGoods> userList = query.list();
				return userList;}
			});
			
			return list;
	}

	@Override
	public List<XyzGoods> findSoldById(int userid) {
		final XyzUser user = this.getHibernateTemplate().get(XyzUser.class, userid);
		/*return (List<XyzGoods>)this.getHibernateTemplate().find("from XyzGoods where xyzUser= ?  and goodsStatus = 0");*/
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query = session.createQuery("select o.xyzGoods from XyzOrder as o where o.xyzUserByOrderSellerId = ?  and o.orderShow = ?");
				query.setEntity(0, user);
				query.setInteger(1, 1);
				List<XyzGoods> userList = query.list();
				return userList;}
			});
			
			return list;
	}

	@Override
	public List<XyzGoods> findBoughtById(int userid) {
		final XyzUser user = this.getHibernateTemplate().get(XyzUser.class, userid);
		/*return (List<XyzGoods>)this.getHibernateTemplate().find("from XyzGoods where xyzUser= ?  and goodsStatus = 0");*/
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query = session.createQuery("select o.xyzGoods from XyzOrder as o where o.xyzUserByOrderBuyerId = ?  and o.orderShow = ?");
				query.setEntity(0, user);
				query.setInteger(1, 1);
				List<XyzGoods> userList = query.list();
				return userList;}
			});
			
			return list;
	}

	@Override
	public List<XyzGoods> findCartById(int userid) {
		final XyzUser user = this.getHibernateTemplate().get(XyzUser.class, userid);
		/*return (List<XyzGoods>)this.getHibernateTemplate().find("from XyzGoods where xyzUser= ?  and goodsStatus = 0");*/
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query = session.createQuery("select o.xyzGoods from XyzCart as o where o.xyzUser= ? and o.xyzGoods.goodsStatus=1");
				query.setEntity(0, user);
				List<XyzGoods> userList = query.list();
				return userList;}
			});
			
			return list;
	}

	@Override
	public void deleteGoodsById(int goodsid) {
		
		XyzGoods goodstemp = this.getHibernateTemplate().get(XyzGoods.class, goodsid);
		goodstemp.setGoodsStatus(0);
		this.getHibernateTemplate().saveOrUpdate(goodstemp);
	}

	

	@Override
	public void deleteCart(XyzCart cart) {
		this.getHibernateTemplate().delete(cart);
		
	}

	@Override
	public void addgoods(XyzGoods goods) {
		this.getHibernateTemplate().save(goods);
	}

	@Override
	public void deleteOrder(XyzOrder order) {
		this.getHibernateTemplate().delete(order);
		
	}
		
	}
