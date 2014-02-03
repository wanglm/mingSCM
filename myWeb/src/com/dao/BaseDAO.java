package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDAO {

	public static boolean updateOrDeleteByHql(String hql,
			SessionFactory sessionFactory) {
		Query query = getQuery(hql, sessionFactory);
		int n = query.executeUpdate();
		boolean isSuccess = false;
		if (n > 0) {
			isSuccess = true;
		}
		return isSuccess;
	}

	public static boolean saveBySql(String sql, SessionFactory sessionFactory) {
		boolean isSuccess = false;
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery(sql);
		int n = query.executeUpdate();
		if (n > 0) {
			isSuccess = true;
		}
		return isSuccess;
	}

	public static List<?> select(String hql, SessionFactory sessionFactory) {
		Query query = getQuery(hql, sessionFactory);
		List<?> list = query.list();
		return list;
	}

	public static Query getQuery(String hql, SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		return session.createQuery(hql);
	}

}
