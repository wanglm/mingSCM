package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDAO {
	private SessionFactory sessionFactory;
	private boolean isSuccess = false;

	public boolean updateOrDeleteByHql(String hql) {
		Query query = getQuery(hql);
		int n = query.executeUpdate();
		if (n > 0) {
			isSuccess = true;
		}
		return isSuccess;
	}

	public boolean saveByHql(String sql) {
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery(sql);
		int n = query.executeUpdate();
		if (n > 0) {
			isSuccess = true;
		}
		return isSuccess;
	}

	public List<?> select(String hql) {
		Query query = getQuery(hql);
		List<?> list = query.list();
		return list;
	}

	public Query getQuery(String hql) {
		Session session = sessionFactory.openSession();
		return session.createQuery(hql);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
