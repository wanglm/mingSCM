package com.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.dao.UserDAO;

public class UserService {

	private JSONObject result;
	private UserDAO dao;

	/**
	 * 删改用户统一方法
	 * 
	 * @param hql
	 * @return
	 */
	public JSONObject updateOrDeleteUser(String hql) {
		result.put("success", dao.upDateOrDeleteUser(hql));
		return result;
	}

	/**
	 * 添加，采用sql
	 * 
	 * @param hql
	 * @return
	 */
	public JSONObject saveUser(String sql) {
		result.put("success", dao.saveUser(sql));
		return result;
	}

	public List<?> selectUser(String hql) {
		List<?> list = dao.readUser(hql);
		return list;
	}

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

}
