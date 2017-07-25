package com.xyz.dao.impl;

import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xyz.dao.XyzOrderDao;
import com.xyz.domain.XyzOrder;

public class XyzOrderDaoImpl extends HibernateDaoSupport implements XyzOrderDao{

	@Override
	public void add(final XyzOrder order) {
		this.getHibernateTemplate().save(order);
		this.getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query  = session.createQuery("update XyzGoods set goodsStatus = 0 where goodsId = ?");
				query.setInteger(0, order.getXyzGoods().getGoodsId());
				query.executeUpdate();
				return null;
			}
		});
	}

}
