package com.bit.action;

import com.bit.model.GuestDao;
import com.bit.model.entity.GuestVo;
import com.opensymphony.xwork2.Action;

public class DetailAction implements Action {

	private int idx;
	private GuestVo bean;
	
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public GuestVo getBean() {
		return bean;
	}

	@Override
	public String execute() throws Exception {
		GuestDao dao = new GuestDao();
		bean=dao.selectOne(idx);
		return this.SUCCESS;
	}

}
