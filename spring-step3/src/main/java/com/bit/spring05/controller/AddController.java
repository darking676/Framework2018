package com.bit.spring05.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.bit.spring05.model.GuestDao;
import com.bit.spring05.model.GuestDaoImf;
import com.bit.spring05.model.entity.GuestVo;

/*
 * 
 * get -> 1 2
 * post -> 1 2 3 4 5
 * post, err -> 1 2 3
 * 
 * 1.handleRequest() run...
 * 2.handleRequestInternal() run...
 * 3.onBind() run...
 * 4.onSubmit() run...
 * 5.doSubmitAction() run...
 * 
*/
public class AddController extends SimpleFormController {
	
	private GuestDao dao;
	
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return super.handleRequest(request, response);
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return super.handleRequestInternal(request, response);
	}
	@Override
	protected void onBind(HttpServletRequest request, Object command,
			BindException errors) throws Exception {
		List<FieldError> errList = errors.getAllErrors();
		Map<String, String> errs = new HashMap<String, String>();
		for(int i=0; i<errList.size(); i++){
			System.out.println(errList.get(i).getField());
			System.out.println(errList.get(i).getDefaultMessage());
			errs.put(errList.get(i).getField(), errList.get(i).getDefaultMessage());
		}
		GuestVo bean = (GuestVo)command;
		System.out.println(bean);
		System.out.println(request.getParameter("name"));
		if("".equals(request.getParameter("name"))) errs.put("name","ºó¹®ÀÚ ºÒ°¡");
		
		request.setAttribute("errs", errs);
	}
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
					throws Exception {
		if(errors.hasErrors()) return new ModelAndView("guest/add");
		return super.onSubmit(request, response, command, errors);
	}
	@Override
	protected void doSubmitAction(Object command) throws Exception {
		dao.insertOne((GuestVo)command);
	}
	
}
