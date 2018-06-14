package com.bit.action;

import java.util.List;

import com.bit.model.GuestDao;
import com.bit.model.entity.GuestVo;
import com.opensymphony.xwork2.Action;

public class ListAction implements Action {
	private List<GuestVo> list;
	private String msg="";

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}
	public List<GuestVo> getList() {
		return list;
	}

	@Override
	public String execute() throws Exception {
		GuestDao dao = new GuestDao();
		list=dao.selectAll();
		return this.SUCCESS;
	}

}
