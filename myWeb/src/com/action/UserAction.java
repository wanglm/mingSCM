package com.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;
import com.util.Dates;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 8542035684950417689L;

	private String actionType;
	private List<?> list;
	private UserService us;
	private String userName;
	private User user;
	private JSONObject result;
	private Long id;
	private String sd;
	private String ed;

	public String execute() {
		String hql = "";
		String myReturn = "success";
		if (actionType.equalsIgnoreCase("select")) {
			hql = "from User user where 1=1 ";
			if (userName != "" & userName != null) {
				hql += " and user_name='" + userName+"'";
			}
			if (sd != "" & sd != null){
				Long beginDate=Dates.parse(sd).getTime();
				hql+=" and user.createTime>"+beginDate;
			}
			if (ed != "" & ed != null){
				Long endDate=Dates.parse(ed).getTime();
				hql+=" and user.createTime<="+endDate;
			}
			list = us.selectUser(hql);
		} else if (actionType.equalsIgnoreCase("update")) {
			hql = "from User user where user.id=" + id;
			list = us.selectUser(hql);
			myReturn = "save";
		}else if(actionType.equalsIgnoreCase("insert")){
			myReturn = "save";
		}
		return myReturn;
	}

	public Map<String, Object> getSession() {
		return ActionContext.getContext().getSession();
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	public String getSd() {
		return sd;
	}

	public void setSd(String sd) {
		this.sd = sd;
	}

	public String getEd() {
		return ed;
	}

	public void setEd(String ed) {
		this.ed = ed;
	}

}
