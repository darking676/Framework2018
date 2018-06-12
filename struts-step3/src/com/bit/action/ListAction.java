package com.bit.action;

import java.util.List;

import com.hb.model.GuestDao;
import com.hb.model.entity.GuestVo;
import com.opensymphony.xwork2.Action;

public class ListAction implements Action {

	private List<GuestVo> alist;
	
	public List<GuestVo> getAlist() {
		return alist;
	}

	@Override
	public String execute() throws Exception {
		GuestDao dao = new GuestDao();
		alist=dao.selectAll();
		
		
		return this.SUCCESS;
	}

}
