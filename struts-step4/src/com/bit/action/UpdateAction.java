package com.bit.action;

import com.bit.model.GuestDao;
import com.bit.model.entity.GuestVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
/*
 * 스트럿츠2 장점
 * 
 * 1. 쉽고
 * 2. 가볍다 - java Web
 * 3. 생산성 빠르고
 * 4. 보안 높다
 * 5. 모듈화
 * 6. POJO기반
 * 
*/
public class UpdateAction extends ActionSupport 
				implements ModelDriven<GuestVo>, Preparable {
	GuestVo bean;
	
	public void setBean(GuestVo bean) {
		this.bean = bean;
	}
	public GuestVo getBean() {
		return bean;
	}

	@Override
	public void validate() {
		if(bean.getName()==null || bean.getName().equals("")){
			addFieldError("errmsg", "이름을 반드시 입력하세요");
		}else if(bean.getPay()<0){
			addFieldError("errmsg", "금액을 확인하세요");			
		}
	}
	@Override
	public String execute() throws Exception {
		GuestDao dao = new GuestDao();
		int result=dao.updateOne(bean);
		if(result<1)return this.ERROR;
		return this.SUCCESS;
	}

	@Override
	public GuestVo getModel() {
		// TODO Auto-generated method stub
		return this.bean;
	}

	@Override
	public void prepare() throws Exception {
		bean = new GuestVo();
	}
}
