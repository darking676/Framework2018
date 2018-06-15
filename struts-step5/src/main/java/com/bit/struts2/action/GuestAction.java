package com.bit.struts2.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.bit.struts2.model.GuestDao;
import com.bit.struts2.model.GuestDao2;
import com.bit.struts2.model.entity.GuestVo;
import com.opensymphony.xwork2.ModelDriven;

public class GuestAction implements ModelDriven<GuestVo> {
	// POJO
	GuestDao dao = new GuestDao();
	Logger log = Logger.getLogger(getClass());
	private List<GuestVo> list;
	private String msg;
	private int idx;
	private GuestVo bean=new GuestVo();
	
	public List<GuestVo> getList() {
		return list;
	}
	public String getMsg() {
		return msg;
	}
	public GuestVo getBean() {
		return bean;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public void setBean(GuestVo bean) {
		this.bean = bean;
	}
	
	public String one() throws Exception{
		log.debug("detail()");
		bean=dao.selectOne(idx);
		return "success";
	}

	public String list() throws Exception{
		log.debug("execute()");
		GuestDao2 dao = new GuestDao2();
		list=dao.selectAll();
		return "success";
	}
	
	public String execute() throws Exception{
		return "success";
	}
	public String delete() throws Exception{
		if(dao.deleteOne(idx)>0)return "success";
		else return "error";
	}
	public String update() throws Exception{
		if(dao.updateOne(bean)>0) return "success";
		else return "error";
	}
	public String add() throws Exception{
		dao.insertOne(bean);
		return "success";
	}
	@Override
	public GuestVo getModel() {
		return bean;
	}
	
}
