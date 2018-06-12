package com.bit.action;

import com.hb.model.GuestDao;
import com.hb.model.entity.GuestVo;
import com.opensymphony.xwork2.Action;

public class InsertAction implements Action{

	private int sabun;
	private String name;
	private int pay;
	
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	@Override
	public String execute() throws Exception {
		GuestDao dao = new GuestDao();
		GuestVo bean = new GuestVo(
				sabun,name,null,pay
				);
		System.out.println(bean);
		dao.insertOne(bean);
		return this.SUCCESS;
	}
}
