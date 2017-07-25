package com.xyz.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xyz.dao.XyzUserDao;
import com.xyz.domain.XyzGoods;
import com.xyz.domain.XyzUser;

public class XyzUserDaoImpl extends HibernateDaoSupport implements XyzUserDao{

	@Override
	public XyzUser findUserByID(int userId) {
		return this.getHibernateTemplate().get(XyzUser.class, userId);
	}

	@Override
	public List<XyzUser> login(final String userName, final String userPassword) {
		List userList = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query  = session.createQuery("from XyzUser where userName = ? and userPassword = ?");
				query.setString(0, userName);
				query.setString(1,userPassword);
				List<XyzGoods> userList = query.list();
				return userList;
			}
		});
		System.out.println("111");
		return userList;
	}

	@Override
	public XyzUser findUserByNameAndPassword(String userName,
			String userPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int register(XyzUser user,final String username) {
		List userList = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query  = session.createQuery("from XyzUser where userName = ?");
				query.setString(0, username);

				List<XyzGoods> userList = query.list();
				return userList;
			}
		
	});
		if(userList.isEmpty()){
		this.getHibernateTemplate().save(user);
		return 0;
		}
		else if(!userList.isEmpty())
			{
			return 1;
			}
		return 1;
	}

	@Override
	public void info(XyzUser user) {
		this.getHibernateTemplate().update(user);
	}

}
