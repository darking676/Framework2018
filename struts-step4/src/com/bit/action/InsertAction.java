package com.bit.action;

import com.bit.model.GuestDao;
import com.bit.model.entity.GuestVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class InsertAction implements Action, ModelDriven<GuestVo> {

	private GuestVo bean=new GuestVo();
	
	public void setBean(GuestVo bean) {
		this.bean = bean;
	}

	@Override
	public String execute() throws Exception {
		GuestDao dao = new GuestDao();
		dao.insertOne(bean);
		
		return this.SUCCESS;	
	}

	@Override
	public GuestVo getModel() {
		return bean;
	}


}
