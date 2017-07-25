package com.xyz.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xyz.dao.XyzCartDao;
import com.xyz.domain.XyzCart;
import com.xyz.domain.XyzCartId;
import com.xyz.domain.XyzGoods;
import com.xyz.domain.XyzUser;

public class XyzCartDaoImpl extends HibernateDaoSupport implements XyzCartDao{

	@Override
	public void update(XyzCart cart) {
		this.getHibernateTemplate().update(cart);
		
	}

	@Override
	public void delete(XyzCartId cartId) {
		XyzCart cart = this.getHibernateTemplate().load(XyzCart.class, cartId);
		this.getHibernateTemplate().delete(cart);
		
	}

	@Override
	public void add(XyzCart cart) {
		this.getHibernateTemplate().save(cart);
		
	}

	@Override
	public XyzCart findCartByUserAndGoods(XyzUser user, XyzGoods goods) {
		XyzCart cart =new XyzCart();
		XyzCartId cartId = new XyzCartId();
		cartId.setCartBuyerId(user.getUserId());
		cartId.setCartGoodsId(goods.getGoodsId());
		cart.setId(cartId);
		cart.setXyzUser(user);
		cart.setXyzGoods(goods);
		return cart;
	}
	@Override
	public int check(final int userid, final int goodsid) {
		List userList = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
						Query query  = session.createQuery("from XyzCart where xyzUser.userId = ? and xyzGoods.goodsId = ?");
				query.setInteger(0, userid);
				query.setInteger(1, goodsid);
				List<XyzCart> userList = query.list();
				return userList;
			}		
	});
		if(userList.isEmpty())
		{return 0;}
		else if(!userList.isEmpty())
		{return 1;}
		return 1;
	}

}
