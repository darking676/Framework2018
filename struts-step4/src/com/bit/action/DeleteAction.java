package com.bit.action;

import com.bit.model.GuestDao;
import com.opensymphony.xwork2.Action;

public class DeleteAction implements Action {

	private int idx;
	
	public void setIdx(int idx) {
		this.idx = idx;
	}

	@Override
	public String execute() throws Exception {
		GuestDao dao = new GuestDao();
		if(dao.deleteOne(idx)>0){
			return this.SUCCESS;
		}else{
			return this.ERROR;
		}
	}

}
