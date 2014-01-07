package com.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

public class LoginAction extends ActionSupport {

	/**
	 * 登陆控制器
	 * 
	 * 
	 */
	private static final long serialVersionUID = -6434128483294080524L;
	private User user;
	private JSONObject result;
	private UserService us;
	private String isExit;

	public String execute() {
		boolean isSuccess = false;
		Map<String, Object> session = ActionContext.getContext()
				.getSession();
		result = new JSONObject();
		if (isExit == null) {
			String hql = "from User user where user.userName='"
					+ user.getUserName() + "' and user.userPass="
					+ user.getUserPass();
			List<?> list = us.selectUser(hql);
			if (list.size() != 0) {
				isSuccess = true;
			}
			User user = (User) list.get(0);
			session.put("username", user.getUserName());
			session.put("userid", user.getUserId());
			result.put("success", isSuccess);
			result.put("id", user.getId());
		} else {
			session.remove("userid");
			session.remove("username");
			result.put("success", true);
		}
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}

	public String getIsExit() {
		return isExit;
	}

	public void setIsExit(String isExit) {
		this.isExit = isExit;
	}

}
