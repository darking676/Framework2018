package com.bit.action;

import java.sql.Date;

import com.hb.model.GuestDao;
import com.hb.model.entity.GuestVo;
import com.opensymphony.xwork2.Action;

public class DetailAction implements Action{
	private String action="»ó¼¼";
	private String name;
	private Date nalja;
	private int idx,sabun,pay;
	
	public String getAction() {
		return action;
	}
	
	public String getName() {
		return name;
	}

	public Date getNalja() {
		return nalja;
	}

	public int getSabun() {
		return sabun;
	}

	public int getPay() {
		return pay;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	@Override
	public String execute() throws Exception {
		
		GuestDao dao = new GuestDao();
		GuestVo bean=dao.selectOne(idx);
		sabun=bean.getSabun();
		name=bean.getName();
		nalja=bean.getNalja();
		pay=bean.getPay();
		
		return this.SUCCESS;
	}
}









