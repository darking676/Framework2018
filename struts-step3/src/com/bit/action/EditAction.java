package com.bit.action;

import java.sql.Date;

import com.hb.model.GuestDao;
import com.hb.model.entity.GuestVo;
import com.opensymphony.xwork2.Action;

public class EditAction implements Action{
	private String action="¼öÁ¤";
	private int idx;
	private int sabun;
	private String name;
	private Date nalja;
	private int pay;
	
	public String getAction() {
		return action;
	}
	
	public int getSabun() {
		return sabun;
	}

	public String getName() {
		return name;
	}

	public Date getNalja() {
		return nalja;
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
