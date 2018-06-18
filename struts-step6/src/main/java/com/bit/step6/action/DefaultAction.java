package com.bit.step6.action;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.bit.step6.model.GuestDao;
import com.bit.step6.model.entity.GuestVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class DefaultAction implements Action,Preparable, ModelDriven<GuestVo> {
	private Logger log=Logger.getLogger(getClass());
	private List<GuestVo> list;
	private GuestVo bean;
	private static String id="guest";
	
	
	public List<GuestVo> getList() {
		return list;
	}
	public GuestVo getBean() {
		return bean;
	}
	public void setBean(GuestVo bean) {
		this.bean = bean;
	}

	@Override
	public String execute() throws Exception {
		
		if(id.equals("guest"))return this.LOGIN;
		log.debug(id+" : index.action 실행");
		return this.SUCCESS;
	}
	
	public String list() throws Exception{
		if(id.equals("guest"))return this.LOGIN;
		log.debug(id+" : list() run...");
		GuestDao dao = new GuestDao();
		list=dao.selectAll();
		for(GuestVo bean : list){
			log.debug(bean);
		}
		return this.SUCCESS;
	}
	
	public String one() throws Exception{
		if(id.equals("guest"))return this.LOGIN;
		log.debug(id+" : one() run...");
		log.debug(bean.getSabun());
		GuestDao dao = new GuestDao();
		bean=dao.selectOne(bean.getSabun());
		return this.SUCCESS;
	}
	
	public String add() throws Exception{
		if(id.equals("guest"))return this.LOGIN;
		log.debug(id+" : add() run..."); 
		GuestDao dao = new GuestDao();
		dao.insertOne(bean);
		return this.SUCCESS;
	}
	
	public String edit() throws Exception{
		if(id.equals("guest"))return this.LOGIN;
		log.debug(id+" : edit() run...");
		GuestDao dao = new GuestDao();
		if(dao.updateOne(bean)>0) return this.SUCCESS;
		return this.ERROR;
	}
	
	public String del() throws Exception{
		if(id.equals("guest"))return this.LOGIN;
		log.debug(id+" : del() run...");
		GuestDao dao = new GuestDao();
		if(dao.deleteOne(bean.getSabun())>0) return this.SUCCESS;
		return this.ERROR;
	}
	
	public String login() throws Exception{
		/// struts에서 session 사용시 ///
		ActionContext cntxt = ActionContext.getContext(); 
		Map session = cntxt.getSession();
		/////////////////////////////////
		GuestDao dao = new GuestDao();
		if(dao.selectCnt(bean)>0){ 
			id=bean.getName();
			return this.SUCCESS;
		}
		return this.LOGIN;
	}

	@Override
	public GuestVo getModel() {
		return bean;
	}

	@Override
	public void prepare() throws Exception {
		bean = new GuestVo();
	}

}













