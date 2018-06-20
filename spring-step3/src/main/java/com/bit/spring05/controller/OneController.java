package com.bit.spring05.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.bit.spring05.model.GuestDao;
import com.bit.spring05.model.GuestDaoImf;

public class OneController extends AbstractController {
	private GuestDao dao;
	private String viewName;
	
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int pk = Integer.parseInt(request.getParameter("idx"));
		
		ModelAndView mav = new ModelAndView(viewName);
		
		mav.addObject("bean", dao.selectOne(pk));
		
		return mav;
	}

}
