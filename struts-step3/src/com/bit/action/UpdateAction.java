package com.bit.action;

import com.hb.model.GuestDao;
import com.hb.model.entity.GuestVo;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport {
	private int sabun,pay;
	private String name;
	
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String execute() throws Exception {
		GuestDao dao = new GuestDao();
		int result=dao.updateOne(new GuestVo(sabun,name,null,pay));
		if(result>0)return this.SUCCESS;
		else return this.ERROR;
	}
	
	@Override
	public void validate() {
		if("".equals(name))addFieldError("name", "입력하세요");
		if(pay==0)addFieldError("pay", "입력하세요");
	}
	
}

















